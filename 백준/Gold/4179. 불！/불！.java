import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int[][] maze;
    private static Coordinate jihoon;
    private static List<Coordinate> fire = new ArrayList<>();
    private static int[] dx = new int[]{-1, 0, 0, 1};
    private static int[] dy = new int[]{0, -1, 1, 0};


    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int column = Integer.parseInt(inputs[1]);
            maze = new int[row][column];

            for (int i = 0; i < row; i++) {
                char[] chars = reader.readLine().trim().toCharArray();
                for (int j = 0; j < column; j++) {
                    if (chars[j] == '#') {
                        maze[i][j] = -1;
                    } else if (chars[j] == 'J') {
                        jihoon = new Coordinate(i, j);
                        maze[i][j] = 0;
                    } else if (chars[j] == 'F') {
                        fire.add(new Coordinate(i, j));
                        maze[i][j] = 0;
                    } else {
                        maze[i][j] = 0;
                    }
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] makeFireMaze() {
        int[][] fireMaze = new int[maze.length][maze[0].length];
        Queue<Coordinate> queue = new LinkedList<>();
        fire.forEach(f -> queue.add(new Coordinate(f.getX(), f.getY())));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int count = fireMaze[current.getX()][current.getY()];

            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];
                if (isValid(newX, newY) && maze[newX][newY] != -1 && fireMaze[newX][newY] == 0 && !fire.contains(new Coordinate(newX, newY))) {
                    fireMaze[newX][newY] = count + 1;
                    queue.add(new Coordinate(newX, newY));
                }
            }
        }

        fire.forEach(f -> fireMaze[f.getX()][f.getY()] = -1);

        return fireMaze;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[x].length;
    }

    private static String calculate(int[][] fireMaze) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(jihoon);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int count = maze[current.getX()][current.getY()];
            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];

                if (!isValid(newX, newY)) {
                    return String.valueOf(count + 1);
                }

                if ((fireMaze[newX][newY] == 0 || count + 1 < fireMaze[newX][newY]) && maze[newX][newY] == 0) {
                    maze[newX][newY] = count + 1;
                    queue.add(new Coordinate(newX, newY));
                }
            }
        }

        return "IMPOSSIBLE";
    }

    private static void run() {
        int[][] fireMaze = makeFireMaze();
        System.out.println(calculate(fireMaze));
    }

    public static void main(String[] args) {
        readInput();
        run();
    }
}

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        Coordinate other = (Coordinate) obj;

        return this.getX() == other.getX() && this.getY() == other.getY();
    }
}