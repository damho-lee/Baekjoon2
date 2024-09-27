import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int base = Integer.parseInt(inputs[0]);
            int exponent = Integer.parseInt(inputs[1]);
            int divisor = Integer.parseInt(inputs[2]);

            System.out.println(pow(base, exponent, divisor));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long pow(int base, int exponent, int divisor) {
        if (exponent == 0) {
            return 1;
        }

        long n = pow(base, exponent / 2, divisor);

        if (exponent % 2 == 0) {
            return n * n % divisor;
        } else {
            return (n * n % divisor) * base % divisor;
        }
    }
}