import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Solution.fibonacci(Integer.parseInt(reader.readLine().trim())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private static final int DIVISOR = 1_000_000_007;
    private Solution() {
    }

    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n은 0 이상이어야 합니다.");
        }

        if (n < 2) {
            return n;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % DIVISOR;
        }

        return dp[n];
    }
}