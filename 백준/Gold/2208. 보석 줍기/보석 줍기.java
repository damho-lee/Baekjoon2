import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] array;
    private static int m;

    private static int simulate() {
        int[] sum = new int[array.length];
        int[] dp = new int[array.length];
        sum[0] = array[0];
        dp[0] = array[0];

        for (int i = 1; i < m; i++) {
            sum[i] += sum[i - 1] + array[i];
        }

        dp[m - 1] = sum[m - 1];
        int result = 0;

        for (int i = m; i < array.length; i++) {
            sum[i] = sum[i - 1] + array[i] - array[i - m];
            dp[i] = Math.max(sum[i], dp[i - 1] + array[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            m = Integer.parseInt(inputs[1]);

            array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(reader.readLine().trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(simulate());
    }
}
