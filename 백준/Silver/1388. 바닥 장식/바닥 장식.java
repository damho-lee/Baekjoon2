import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[] dx = new int[]{-1, 0, 0, 1};
    int[] dy = new int[]{0, 1, -1, 0};

    private static char[][] readInput() {
        char[][] graph;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int col = Integer.parseInt(inputs[1]);
            graph = new char[row][col];

            for (int i = 0; i < row; i++) {
                graph[i] = reader.readLine().trim().toCharArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return graph;
    }

    private static void print(char[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int run(char[][] graph) {
        int count = 0;
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, graph, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int x, int y, char[][] graph, boolean[][] visited) {
        visited[x][y] = true;
        if (graph[x][y] == '-' && y + 1 < graph[0].length && graph[x][y] == graph[x][y + 1] && !visited[x][y + 1]) {
            dfs(x, y + 1, graph, visited);
        } else if (graph[x][y] == '|' && x + 1 < graph.length && graph[x][y] == graph[x + 1][y] && !visited[x + 1][y]) {
            dfs(x + 1, y, graph, visited);
        }
    }

    public static void main(String[] args) {
        char[][] graph = readInput();
        System.out.println(run(graph));
    }
}
