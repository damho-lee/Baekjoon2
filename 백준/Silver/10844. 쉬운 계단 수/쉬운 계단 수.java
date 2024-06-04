import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long calculate(int n) {
        int divisor = 1_000_000_000;
        int array[][] = new int[n + 1][10];

        for (int i = 1; i < 10; i++) {
            array[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 9) {
                    array[i][j] = array[i - 1][8] % divisor;
                } else if (j == 0) {
                    array[i][j] = array[i - 1][1] % divisor;
                } else {
                    array[i][j] = (array[i - 1][j - 1] + array[i - 1][j + 1]) % divisor;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += array[n][i];
        }

        return result % divisor;
    }

    private static void run() {
        int n = readInput();
        System.out.println(calculate(n));
    }

    public static void main(String[] args) {
        run();
    }
}
