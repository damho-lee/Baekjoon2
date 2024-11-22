import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int[][] graph = new int[n][m];
            for (int i = 0; i < n; i++) {
                graph[i] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            System.out.println(Solution.solve(graph));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private static final int SOUTHWEST = 0;
    private static final int SOUTH = 1;
    private static final int SOUTHEAST = 2;

    private Solution() {
    }

    public static int solve(int[][] graph) {
        int row = graph.length;
        int column = graph[0].length;

        int[][][] dp = new int[row][column][3];
        for (int i = 0; i < column; i++) {
            dp[0][i][0] = graph[0][i];
            dp[0][i][1] = graph[0][i];
            dp[0][i][2] = graph[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0) {
                    dp[i][j][SOUTHWEST] = Math.min(dp[i - 1][j + 1][SOUTHEAST], dp[i - 1][j + 1][SOUTH]) + graph[i][j];
                    dp[i][j][SOUTH] = dp[i - 1][j][SOUTHWEST] + graph[i][j];
                } else if (j == column - 1) {
                    dp[i][j][SOUTHEAST] = Math.min(dp[i - 1][j - 1][SOUTHWEST], dp[i - 1][j - 1][SOUTH]) + graph[i][j];
                    dp[i][j][SOUTH] = dp[i - 1][j][SOUTHEAST] + graph[i][j];
                } else {
                    dp[i][j][SOUTHWEST] = Math.min(dp[i - 1][j + 1][SOUTH], dp[i - 1][j + 1][SOUTHEAST]) + graph[i][j];
                    dp[i][j][SOUTH] = Math.min(dp[i - 1][j][SOUTHWEST], dp[i - 1][j][SOUTHEAST]) + graph[i][j];
                    dp[i][j][SOUTHEAST] = Math.min(dp[i - 1][j - 1][SOUTHWEST], dp[i - 1][j - 1][SOUTH]) + graph[i][j];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.min(result, dp[row - 1][i][j]);
            }
        }

        return result;
    }
}