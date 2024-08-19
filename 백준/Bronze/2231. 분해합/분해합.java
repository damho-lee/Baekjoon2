import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean isDecompositionSum(int generator, int n) {
        String string = String.valueOf(generator);
        int sum = generator;
        for (int i = 0; i < string.length(); i++) {
            sum += string.charAt(i) - '0';
        }

        return sum == n;
    }

    public static void main(String[] args) {
        int n;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException();
        }

        for (int i = 1; i < n; i++) {
            if (isDecompositionSum(i, n)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}
