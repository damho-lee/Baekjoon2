import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calculate(int input) {
        StringBuffer stringBuffer = new StringBuffer();

        if (input == 0) {
            stringBuffer.append(0);
            stringBuffer.append("\n");
            stringBuffer.append(0);
        } else {
            int n = Math.abs(input);
            int[] array = new int[n + 1];
            array[0] = 0;
            array[1] = 1;

            for (int i = 2; i < array.length; i++) {
                array[i] = (array[i - 2] + array[i - 1]) % 1000000000;
            }

            if (input < 0 && Math.abs(input) % 2 == 0) {
                stringBuffer.append(-1);
            } else {
                stringBuffer.append(1);
            }

            stringBuffer.append("\n");
            stringBuffer.append(array[n]);
        }

        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        int n = readInput();
        calculate(n);
    }
}
