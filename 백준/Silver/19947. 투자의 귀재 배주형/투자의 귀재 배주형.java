import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int base;
    private static int year;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            base = Integer.parseInt(inputs[0]);
            year = Integer.parseInt(inputs[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long calculate() {
        long[] dp = new long[year + 1];
        dp[0] = base;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = (long) Math.floor(dp[i - 1] * 1.05);
            if (i >= 3) {
                dp[i] = Math.max(dp[i], (long) Math.floor(dp[i - 3] * 1.2));
            }

            if (i >= 5) {
                dp[i] = Math.max(dp[i], (long) Math.floor(dp[i - 5] * 1.35));
            }
        }

        return dp[year];
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
