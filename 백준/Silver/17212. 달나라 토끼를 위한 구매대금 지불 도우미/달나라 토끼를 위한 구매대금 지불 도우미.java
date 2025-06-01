import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int target;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            target = Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Solution.calculate(target));
    }
}

class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private static int[] coins;

    public static int calculate(int target) {
        if (coins == null) {
            init();
        }

        int[] dp = new int[target + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[target];
    }

    private static void init() {
        coins = new int[]{1, 2, 5, 7};
    }
}