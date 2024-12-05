import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            System.out.println(Solution.calculate(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    public static int calculate(int n) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + i;
        }

        return dp[n - 1];
    }
}