import java.io.*;

public class Main {
    private static int[] powers;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < n; i++) {
                writer.write(Solution.calculate(Integer.parseInt(reader.readLine().trim())) + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    private static final int SIZE = 191229;
    private static final int DIVISOR = 1_000_000_007;

    private static int[] dpArray;

    private static void init() {
        dpArray = new int[SIZE + 1];
        dpArray[1] = 1;
        dpArray[2] = 2;

        for (int i = 3; i < dpArray.length; i++) {
            dpArray[i] = (dpArray[i - 1] + dpArray[i - 2]) % DIVISOR;
        }
    }

    public static int calculate(int n) {
        if (dpArray == null) {
            init();
        }

        return dpArray[n];
    }
}