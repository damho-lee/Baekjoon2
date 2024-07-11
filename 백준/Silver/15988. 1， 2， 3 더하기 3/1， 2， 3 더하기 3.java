import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] inputs;
    private static int max;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            inputs = new int[n];
            max = 0;
            for (int i = 0; i < n; i++) {
                inputs[i] = Integer.parseInt(reader.readLine().trim());
                max = Math.max(max, inputs[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String calculate() {
        long[] array = new long[max + 1];
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        for (int i = 4; i <= max; i++) {
            array[i] = (array[i - 3] + array[i - 2] + array[i - 1]) % 1000000009;
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < inputs.length; i++) {
            stringBuffer.append(array[inputs[i]] + "\n");
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
