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

    private static String calculate(int n) {
        String result = n % 2 == 1 ? "SK" : "CY";
        return result;
    }

    private static void run() {
        int n = readInput();
        System.out.println(calculate(n));
    }

    public static void main(String[] args) {
        run();
    }
}
