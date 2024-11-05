import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            System.out.println(BinomialCoefficient.calculate(n, k));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class BinomialCoefficient {
    private BinomialCoefficient() {
    }

    private static final int DIVISOR = 10007;

    public static int calculate(int n, int k) {
        int[][] array = new int[n + 1][n + 1];

        for (int i = 1; i < array.length; i++) {
            array[i][0] = 1;
            array[i][i] = 1;
        }

        for (int i = 2; i < array.length; i++) {
            for (int j = 1; j < i; j++) {
                array[i][j] = (array[i - 1][j - 1] + array[i - 1][j]) % DIVISOR;
            }
        }

        return array[n][k];
    }
}