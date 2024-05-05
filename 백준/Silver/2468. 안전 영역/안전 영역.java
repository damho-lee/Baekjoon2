import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    private static final int[] dx = new int[]{-1, 0, 0, 1};
    private static final int[] dy = new int[]{0, 1, -1, 0};
    private static int[][] graph;
    private static int maxHeight;

    private static int[][] readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] inputs = reader.readLine().trim().split(" ");
                graph[i] = Stream.of(inputs).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                maxHeight = maxHeight > graph[i][j] ? maxHeight : graph[i][j];
            }
        }

        return graph;
    }

    private static int calculate(int[][] graph) {
        int max = 0;
        boolean[][] visited;
        for (int k = 0; k <= maxHeight; k++) {
            int count = 0;
            visited = new boolean[graph.length][graph[0].length];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (!visited[i][j] && graph[i][j] > k) {
                        dfs(i, j, k, visited);
                        count++;
                    }
                }
            }

            max = max > count ? max : count;
        }

        return max;
    }

    private static void dfs(int x, int y, int precipitation, boolean[][] visited) {
        visited[x][y] = true;
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(x, y));

        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];
                if (isValid(newX, newY) && !visited[newX][newY] && graph[newX][newY] > precipitation) {
                    stack.push(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[x].length;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate(graph));
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
}