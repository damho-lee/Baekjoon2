import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int n) {
        int[][] dp = new int[n][10];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = j; k < dp[i].length; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        int result = 0;
        for (int i = 0; i < dp[0].length; i++) {
            result += dp[n - 1][i];
        }

        return result % 10007;
    }

    public static void main(String[] args) {
        int n = readInput();
        System.out.println(calculate(n));
    }
}
