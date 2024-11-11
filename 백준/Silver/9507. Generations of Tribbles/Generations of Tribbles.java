import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < n; i++) {
                writer.write(Koong.calculate(Integer.parseInt(reader.readLine().trim())) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Koong {
    private static long[] dpArray;
    private static final int SIZE = 67;

    private Koong() {
    }

    private static void init() {
        dpArray = new long[SIZE + 1];

        dpArray[0] = 1;
        dpArray[1] = 1;
        dpArray[2] = 2;
        dpArray[3] = 4;

        for (int i = 4; i < dpArray.length; i++) {
            dpArray[i] = dpArray[i - 1] + dpArray[i - 2] + dpArray[i - 3] + dpArray[i - 4];
        }
    }

    public static long calculate(int n) {
        if (dpArray == null) {
            init();
        }

        return dpArray[n];
    }
}