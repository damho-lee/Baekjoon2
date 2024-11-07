import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            System.out.println(Solution.calculate(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private static final long DIVISOR = 1_000_000_007L;

    private Solution() {
    }

    public static long calculate(int n) {
        if (n < 2) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = (1 + dp[i - 1] + dp[i - 2]) % DIVISOR;
        }

        return dp[n];
    }
}