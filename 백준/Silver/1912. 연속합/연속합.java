import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[] sequence;
    private static int[] dp;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine().trim());
            dp = new int[size];
            sequence = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        dp[0] = sequence[0];
        int max = dp[0];

        for (int i = 1; i < sequence.length; i++) {
            dp[i] = Math.max(dp[i - 1] + sequence[i], sequence[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
