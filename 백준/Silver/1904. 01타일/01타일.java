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

    private static int calculate(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        long[] array = new long[n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i < array.length; i++) {
            array[i] = (array[i - 2] + array[i - 1]) % 15746;
        }

        return (int) array[n];
    }

    private static void run() {
        int n = readInput();
        System.out.println(calculate(n));
    }

    public static void main(String[] args) {
        run();
    }
}
