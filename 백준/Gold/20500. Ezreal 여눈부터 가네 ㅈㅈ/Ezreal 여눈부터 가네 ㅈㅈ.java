import java.io.*;

public class Main {
    private static final int DIVISOR = 1_000_000_007;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            System.out.println(calculate(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long calculate(int n) {
        if (n == 1) {
            return 0;
        }

        long[][] dp = new long[3][n + 1];
        dp[0][2] = dp[1][2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % DIVISOR;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % DIVISOR;
            dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % DIVISOR;
        }

        return dp[0][n];
    }
}
