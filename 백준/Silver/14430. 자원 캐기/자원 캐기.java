import java.io.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int column = Integer.parseInt(inputs[1]);
            int[][] graph = new int[row][];

            for (int i = 0; i < row; i++) {
                graph[i] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            System.out.println(calculate(graph));
            ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int[][] graph) {
        int[][] dp = new int[graph.length][graph[0].length];
        int rowLength = dp.length;
        int columnLength = dp[0].length;

        dp[0][0] = graph[0][0];
        for (int i = 1; i < rowLength; i++) {
            dp[i][0] = dp[i - 1][0] + graph[i][0];
        }

        for (int i = 1; i < columnLength; i++) {
            dp[0][i] = dp[0][i - 1] + graph[0][i];
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + graph[i][j];
            }
        }

        return dp[rowLength - 1][columnLength - 1];
    }
}