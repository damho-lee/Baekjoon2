import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            System.out.println(calculate(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int n) {
        if (n % 2 != 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (n == 2) {
            return 3;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        int tmp = 0;

        for (int i = 4; i < dp.length; i += 2) {
            dp[i] = dp[i - 2] * 3 + 2 + tmp * 2;
            tmp += dp[i - 2];
        }

        return dp[n];
    }
}
