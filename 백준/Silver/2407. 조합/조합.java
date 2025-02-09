import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            System.out.println(calculate(n, m));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BigInteger calculate(int n, int m) {
        if (m == 0 || n == m) {
            return BigInteger.ONE;
        }

        BigInteger[][] array = new BigInteger[101][101];
        for (int i = 0; i <= n; i++) {
            array[i][0] = BigInteger.ONE;
            array[i][i] = BigInteger.ONE;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                array[i][j] = array[i - 1][j].add(array[i - 1][j - 1]);
            }
        }

        return array[n][m];
    }
}