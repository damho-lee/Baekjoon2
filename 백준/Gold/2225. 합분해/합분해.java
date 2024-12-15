import java.io.*;
import java.util.Arrays;

public class Main {
    private static final int DIVISOR = 1_000_000_000;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            System.out.println(calculate(n, k));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        Arrays.fill(dp[1], 1);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % DIVISOR;
            }
        }

        return dp[k][n];
    }
}