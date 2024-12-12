import java.io.*;
import java.util.Arrays;

public class Main {
    private static final int DIVISOR = 1_234_567;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberOfCase = Integer.parseInt(reader.readLine().trim());
            int[] testCase = new int[numberOfCase];
            int max = 0;
            for (int i = 0; i < numberOfCase; i++) {
                testCase[i] = Integer.parseInt(reader.readLine().trim());
                max = Math.max(max, testCase[i]);
            }
            int[][] dp = new int[max + 1][10];
            Arrays.fill(dp[1], 1);

            for (int i = 2; i <= max; i++) {
                dp[i][0] = dp[i - 1][7] % DIVISOR;
                dp[i][1] = (dp[i - 1][2] + dp[i - 1][4]) % DIVISOR;
                dp[i][2] = (dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5]) % DIVISOR;
                dp[i][3] = (dp[i - 1][2] + dp[i - 1][6]) % DIVISOR;
                dp[i][4] = (dp[i - 1][1] + dp[i - 1][5] + dp[i - 1][7]) % DIVISOR;
                dp[i][5] = (dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][6] + dp[i - 1][8]) % DIVISOR;
                dp[i][6] = (dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][9]) % DIVISOR;
                dp[i][7] = (dp[i - 1][4] + dp[i - 1][8] + dp[i - 1][0]) % DIVISOR;
                dp[i][8] = (dp[i - 1][5] + dp[i - 1][7] + dp[i - 1][9]) % DIVISOR;
                dp[i][9] = (dp[i - 1][6] + dp[i - 1][8]) % DIVISOR;
            }

            for (int i : testCase) {
                writer.write((dp[i][0]
                        + dp[i][1]
                        + dp[i][2]
                        + dp[i][3]
                        + dp[i][4]
                        + dp[i][5]
                        + dp[i][6]
                        + dp[i][7]
                        + dp[i][8]
                        + dp[i][9]) % DIVISOR + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}