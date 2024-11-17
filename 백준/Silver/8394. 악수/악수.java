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
    private Solution() {
    }

    public static long calculate(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n 은 1 이상이어야 합니다.");
        }
        if (n < 3) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10;
        }

        return dp[n];
    }
}