import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCase;
            int[] profits;

            while ((testCase = Integer.parseInt(reader.readLine().trim())) != 0) {
                profits = new int[testCase];

                for (int i = 0; i < testCase; i++) {
                    profits[i] = Integer.parseInt(reader.readLine().trim());
                }

                writer.write(calculate(profits) + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int[] profits) {
        int[] dp = new int[profits.length];
        dp[0] = profits[0];

        for (int i = 1; i < profits.length; i++) {
            dp[i] = Math.max(dp[i - 1] + profits[i], profits[i]);
        }

        return Arrays.stream(dp).max().orElse(0);
    }
}