import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static int readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BigInteger calculate(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        } else if (n == 1) {
            return BigInteger.ONE;
        }

        BigInteger[] array = new BigInteger[n + 1];
        array[0] = BigInteger.ZERO;
        array[1] = BigInteger.ONE;

        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 2].add(array[i - 1]);
        }

        return array[n];
    }

    public static void main(String[] args) {
        System.out.println(calculate(readInput()));
    }
}
