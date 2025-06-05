import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int n;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (n == 0) {
            System.out.println(1);
            return;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }

        System.out.println(dp[n]);
    }
}