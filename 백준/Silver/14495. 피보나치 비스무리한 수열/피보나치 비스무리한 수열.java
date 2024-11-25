import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Solution.calculate(Integer.parseInt(reader.readLine().trim())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    public static long calculate(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n은 1 이상이어야 합니다.");
        }

        if (n < 4) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 1];
        }

        return dp[n];
    }
}

class Meeting {
    private int start;
    private int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}