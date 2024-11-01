import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] inputs = new int[n];

            for (int i = 0; i < n; i++) {
                inputs[i] = Integer.parseInt(reader.readLine().trim());
            }

            System.out.println(Solution.calculate(inputs));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    private static final long DIVISOR = 1_000_000_009L;

    public static String calculate(int[] inputs) {
        if (inputs.length == 0) {
            throw new IllegalArgumentException("Solution.calculate() : parameter inputs is empty");
        }

        int max = Arrays.stream(inputs).max().getAsInt();

        long[][] dp = makeDpArray(max);

        for (int i = 4; i < dp.length; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % DIVISOR;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % DIVISOR;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % DIVISOR;
        }

        return getResult(dp, inputs);
    }

    private static String getResult(long[][] resultArray, int[] inputs) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int input : inputs) {
            stringBuffer
                    .append((resultArray[input][1] + resultArray[input][2] + resultArray[input][3]) % DIVISOR)
                    .append("\n");
        }

        return stringBuffer.toString();
    }

    private static long[][] makeDpArray(int n) {
        long[][] dp = new long[n + 1][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        return dp;
    }
}