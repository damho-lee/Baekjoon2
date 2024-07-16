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
        return n % 2 == 0 ? "SK" : "CY";
    }

    public static void main(String[] args) {
        int n = readInput();
        System.out.println(calculate(n));
    }
}
