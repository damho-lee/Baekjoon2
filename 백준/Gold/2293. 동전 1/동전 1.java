import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] coins;
    private static int k;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputs = reader.readLine().trim();
            StringTokenizer stringTokenizer = new StringTokenizer(inputs, " ");
            int n = Integer.parseInt(stringTokenizer.nextToken());
            k = Integer.parseInt(stringTokenizer.nextToken());
            coins = new int[n];

            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(reader.readLine().trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int[] array = new int[k + 1];
        array[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];

            for (int j = coin; j < array.length; j++) {
                array[j] += array[j - coin];
            }
        }

        return array[k];
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
