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
        for (int i = 2; i < array.length; i++) {
            array[i] = Integer.MAX_VALUE;
        }
        array[1] = 1;

        for (int i = 2; i < array.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (array[i] > array[i - j * j] + 1) {
                    array[i] = array[i - j * j] + 1;
                }
            }
        }

        return array[n];
    }

    public static void main(String[] args) {
        int n = readInput();
        System.out.println(calculate(n));
    }
}
