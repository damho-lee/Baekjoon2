import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[][] graph;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            graph = new int[n][n];

            for (int i = 0; i < n; i++) {
                graph[i] = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long calculate() {
        long[][] count = new long[graph.length][graph[0].length];
        count[0][0] = 1;
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    continue;
                }

                int distance = graph[i][j];
                if (isValid(i + distance, j)) {
                    count[i + distance][j] += count[i][j];
                }

                if (isValid(i, j + distance)) {
                    count[i][j + distance] += count[i][j];
                }
            }
        }

        return count[n - 1][n - 1];
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[x].length;
    }

    private static void run() {
        readInput();
        System.out.println(calculate());
    }

    public static void main(String[] args) {
        run();
    }
}