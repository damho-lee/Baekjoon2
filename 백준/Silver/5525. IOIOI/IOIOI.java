import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static String inputs;
    private static int size;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().trim());
            size = Integer.parseInt(reader.readLine().trim());
            inputs = reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int[] dp = new int[inputs.length()];
        int count = 0;

        for (int i = 2; i < inputs.length(); i++) {
            String tmp = inputs.substring(i - 2, i + 1);
            if (tmp.equals("IOI")) {
                dp[i] = dp[i - 2] + 1;
            }

            if (dp[i] >= n) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
