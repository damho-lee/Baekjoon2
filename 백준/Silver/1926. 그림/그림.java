import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    private static int[][] graph;
    private static int dx[] = new int[]{-1, 0, 0, 1};
    private static int dy[] = new int[]{0, -1, 1, 0};

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int column = Integer.parseInt(inputs[1]);
            graph = new int[row][column];

            for (int i = 0; i < graph.length; i++) {
                graph[i] = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;
        int max = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    max = Math.max(max, bfs(i, j, visited));
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static int bfs(int x, int y, boolean[][] visited) {
        int count = 1;
        visited[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];
                if (isValid(newX, newY) && !visited[newX][newY] && graph[newX][newY] == 1) {
                    queue.add(new Point(newX, newY));
                    visited[newX][newY] = true;
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[x].length;
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
