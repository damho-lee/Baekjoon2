import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] health = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] pleasure = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int maxHealth = 100;
            int[] dp = new int[maxHealth];

            for (int i = 0; i < n; i++) {
                for (int j = maxHealth - 1; j >= health[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - health[i]] + pleasure[i]);
                }
            }

            System.out.println(dp[maxHealth - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}