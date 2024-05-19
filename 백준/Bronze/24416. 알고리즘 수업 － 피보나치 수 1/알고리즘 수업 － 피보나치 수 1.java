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

    private static void calculate(int n) {
        int array[] = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        int i = 2;
        while (i < n + 1) {
            array[i] = array[i - 1] + array[i - 2];
            i++;
        }

        System.out.println(array[n] + " " + (i - 3));
    }

    private static void run() {
        int n = readInput();
        calculate(n);
    }

    public static void main(String[] args) {
        run();
    }
}
