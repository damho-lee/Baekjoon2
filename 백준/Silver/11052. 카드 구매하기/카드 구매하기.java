import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] cardPrices;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            cardPrices = new int[n + 1];

            String[] inputs = reader.readLine().split(" ");
            for (int i = 0; i < inputs.length; i++) {
                cardPrices[i + 1] = Integer.parseInt(inputs[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int[] dp = new int[cardPrices.length];

        for (int i = 1; i < cardPrices.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cardPrices[j]);
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
