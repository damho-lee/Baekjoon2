import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] maze;
    private static int[] dx = new int[]{-1, 0, 0, 1};
    private static int[] dy = new int[]{0, -1, 1, 0};

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int column = Integer.parseInt(inputs[1]);
            maze = new int[row][column];
            for (int i = 0; i < row; i++) {
                maze[i] = reader.readLine().chars().map(Character::getNumericValue).toArray();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];

                if (isValid(newX, newY) && maze[newX][newY] == 1) {
                    maze[newX][newY] = maze[current.getX()][current.getY()] + 1;
                    queue.add(new Point(newX, newY));
                }
            }
        }

        System.out.println(maze[maze.length - 1][maze[0].length - 1]);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[x].length;
    }

    public static void main(String[] args) {
        readInput();
        run();
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}