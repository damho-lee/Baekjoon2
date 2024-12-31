import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long result = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            for (int i = 1; i <= n; i++) {
                result += (long) n / i * i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }

    private static int calculate(int number, int exponent) {
        String[] numbers = String.valueOf(number).split("");

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).reduce(0, (total, n) -> (int) (total + Math.pow(n, exponent)));
    }
}