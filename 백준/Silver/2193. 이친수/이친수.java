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
        if (n == 1) {
            return 1;
        }

        long[] array = new long[n + 1];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }

    public static void main(String[] args) {
        int n = readInput();
        System.out.println(calculate(n));
    }
}
