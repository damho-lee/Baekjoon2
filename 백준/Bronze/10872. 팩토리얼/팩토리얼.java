import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            System.out.println(factorial(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int factorial(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
