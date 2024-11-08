import java.io.*;
import java.util.Arrays;

public class Main {
    private static int[] powers;
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            powers = new int[n];
            long[] dp = new long[n];
            String[] inputs = reader.readLine().split(" ");
            for (int i = 0; i < inputs.length; i++) {
                powers[i] = Integer.parseInt(inputs[i]);
            }

            for (int i = 1; i < dp.length; i++) {
                dp[i] = Long.MAX_VALUE;

                for (int j = 0; j < i; j++) {
                    long power = Math.max(calculatePower(i, j), dp[j]);
                    dp[i] = Math.min(dp[i], power);
                }
            }

            System.out.println(dp[n - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long calculatePower(int big, int small) {
        return (long) (big - small) * (1 + Math.abs(powers[big] - powers[small]));
    }
}