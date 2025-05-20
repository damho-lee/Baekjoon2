import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    private static final int UNKNOWN = 0;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCase = Integer.parseInt(reader.readLine().trim());
            int[] coins;
            int money;

            for (int i = 0; i < testCase; i++) {
                int numberOfCoins = Integer.parseInt(reader.readLine());
                coins = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                money = Integer.parseInt(reader.readLine().trim());

                writer.write(calculate(coins, money) + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int[] coins, int money) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, UNKNOWN);
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= money; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[money];
    }
}