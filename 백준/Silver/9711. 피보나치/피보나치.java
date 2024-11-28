import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            System.out.println(Solution.solve(n, reader));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private static String prefix = "Case #";
    private static String postfix = ": ";

    private Solution() {
    }

    public static String solve(int n, BufferedReader reader) {
        StringBuffer stringBuffer = new StringBuffer();

        try {
            String[] inputs;

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");

                stringBuffer.append(prefix)
                        .append(i + 1)
                        .append(postfix)
                        .append(Fibonacci.calculate(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])))
                        .append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Solution::solve() IOException Error");
        }

        return stringBuffer.toString();
    }
}

class Fibonacci {
    private Fibonacci() {
    }

    private static BigInteger[] array;
    private static final int arraySize = 10001;

    public static BigInteger calculate(int n, int divisor) {
        if (array == null) {
            init();
        }

        if (n < 1) {
            throw new IllegalArgumentException("n은 1 이상이어야 합니다.");
        }

        return array[n].mod(BigInteger.valueOf(divisor));
    }

    private static void init() {
        array = new BigInteger[arraySize];
        array[1] = BigInteger.ONE;
        array[2] = BigInteger.ONE;

        for (int i = 3; i < array.length; i++) {
            array[i] = array[i - 1].add(array[i - 2]);
        }
    }
}