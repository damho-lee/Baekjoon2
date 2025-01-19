import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int DIVISOR = 16_769_023;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int result = 1;

            for (int i = 0; i < (n + 1) / 2; i++) {
                result *= 2;
                result %= DIVISOR;
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}