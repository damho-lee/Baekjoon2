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
        int[] array = new int[n + 1];

        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 1; i < array.length; i++) {
            array[i] = i;

            for (int j = 1; j * j <= i; j++) {
                if (array[i] > array[i - j * j] + 1) {
                    array[i] = array[i - j * j] + 1;
                }
            }
        }

        return array[n];
    }

    private static void run() {
        int n = readInput();
        System.out.println(calculate(n));
    }

    public static void main(String[] args) {
        run();
    }
}
