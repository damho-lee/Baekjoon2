import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] soldiers = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (soldiers[i] < soldiers[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            max = Arrays.stream(dp).max().orElse(0);
            System.out.println(n - max);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}