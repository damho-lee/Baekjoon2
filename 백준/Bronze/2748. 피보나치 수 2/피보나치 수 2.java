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

    private static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("input : " + n + ", 0보다 작은 값은 들어올 수 없습니다.");
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long[] array = new long[n + 1];
        array[1] = 1;

        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }

    private static void run() {
        int n = readInput();
        long result = 0;

        try {
            result = fibonacci(n);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        run();
    }
}
