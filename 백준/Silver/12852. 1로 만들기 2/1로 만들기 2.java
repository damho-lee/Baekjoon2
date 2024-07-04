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

    private static void run() {
        int n = readInput();
        int[] dp = new int[n + 1];
        int[] history = new int[n + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 2; i < dp.length; i++) {
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                history[i] = i / 3;
            }

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                history[i] = i / 2;
            }

            if (dp[i] > dp[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
                history[i] = i - 1;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(dp[n] + "\n");
        while(n >= 1) {
            stringBuffer.append(n + " ");
            n = history[n];
        }

        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        run();
    }
}
