import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCase = Integer.parseInt(reader.readLine().trim());
            String[] inputs;

            for (int i = 0; i < testCase; i++) {
                inputs = reader.readLine().split(" ");
                int n = Integer.parseInt(inputs[0]);
                int m = Integer.parseInt(inputs[1]);

                writer.write(Solution.combination(n, m) + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private static int[][] dp;

    private Solution() {
    }

    private static void init() {
        dp = new int[31][31];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
    }

    public static int combination(int n, int m) {
        if (dp == null) {
            init();
        }

        return dp[m][n];
    }
}