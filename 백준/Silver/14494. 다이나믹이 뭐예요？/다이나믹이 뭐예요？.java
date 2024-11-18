import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            System.out.println(Solution.calculate(n, m));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private static final long DIVISOR = 1_000_000_007L;
    private Solution() {
    }

    public static long calculate(int n, int m) {
        long[][] dp = new long[n][m];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1]) % DIVISOR;
            }
        }

        return dp[n - 1][m - 1];
    }
}