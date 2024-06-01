import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] wine;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine().trim());
            wine = new int[size];

            for (int i = 0; i < size; i++) {
                wine[i] = Integer.parseInt(reader.readLine().trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int size = wine.length;

        if (size == 1) {
            return wine[0];
        } else if (size == 2) {
            return wine[0] + wine[1];
        }

        int dp[] = new int[size];
        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        dp[2] = Math.max(Math.max(wine[0], wine[1]) + wine[2], dp[1]);

        for (int i = 3; i < size; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + wine[i - 1]) + wine[i]);
        }

        return dp[size - 1];
    }

    private static void run() {
        readInput();
        System.out.println(calculate());
    }

    public static void main(String[] args) {
        run();
    }
}
