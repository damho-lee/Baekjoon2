import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int a;
    private static int k;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            k = Integer.parseInt(inputs[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int[] dp = new int[k + 1];
        for (int i = a + 1; i < dp.length; i++) {
            dp[i] = (i / 2 >= a && i % 2 == 0 ? Math.min(dp[i - 1], dp[i / 2]) : dp[i - 1]) + 1;
        }

        return dp[k];
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
