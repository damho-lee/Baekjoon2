import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            System.out.println(Solution.calculate(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] makeArray(BufferedReader reader) throws IOException {
        return Stream.of(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

class Solution {
    private Solution() {
    }

    public static long calculate(int n) {
        if (n == 1) {
            return 4;
        } else if (n == 2) {
            return 6;
        }

        long[] dp = new long[n + 1];
        dp[1] = 4;
        dp[2] = 6;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}