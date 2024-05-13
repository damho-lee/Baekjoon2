import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    private static int[][] graph;
    private static int[] dx = new int[]{-1, 0, 0, 1};
    private static int[] dy = new int[]{0, -1, 1, 0};


    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int m = Integer.parseInt(inputs[0]);
            int n = Integer.parseInt(inputs[1]);
            graph = new int[n][m];

            for (int i = 0; i < graph.length; i++) {
                inputs = reader.readLine().trim().split(" ");
                graph[i] = Stream.of(inputs).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isAllRipened() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isAnyFruitsUnripe() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[x].length;
    }

    private static int calculate() {
        if (isAllRipened()) {
            return 0;
        }

        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new Tomato(i, j, 0));
                }
            }
        }

        int day = 0;
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            day = current.getDay();
            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];

                if (isValid(newX, newY) && graph[newX][newY] == 0) {
                    graph[newX][newY] = 1;
                    queue.add(new Tomato(newX, newY, day + 1));
                }
            }
        }

        if (isAnyFruitsUnripe()) {
            return -1;
        }

        return day;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}

class Tomato {
    private int x;
    private int y;
    private int day;

    public Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDay() {
        return day;
    }
}