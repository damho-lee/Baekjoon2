import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    private static int[][] graph;
    private static Point target;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            int distance;

            graph = new int[x][y];

            for (int i = 0; i < x; i++) {
                inputs = reader.readLine().trim().split(" ");
                for (int j = 0; j < y; j++) {
                    distance = Integer.parseInt(inputs[j]);

                    if (distance == 2) {
                        target = new Point(i, j);
                    }

                    graph[i][j] = distance;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calculate() {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        graph[target.getX()][target.getY()] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(target);
        visited[target.getX()][target.getY()] = true;

        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];

                if (isValid(newX, newY) && graph[newX][newY] != 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    graph[newX][newY] = graph[current.getX()][current.getY()] + 1;
                    queue.add(new Point(newX, newY));
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    graph[i][j] = -1;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[x].length;
    }

    private static void print() {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    writer.write(graph[i][j] + " ");
                }
                writer.write("\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        readInput();
        calculate();
        print();
    }

    public static void main(String[] args) {
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
