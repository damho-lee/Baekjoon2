import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] inputs = reader.readLine().split(" ");
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(inputs[i]);
            }

            return values;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("올바른 배열이 아닙니다.");
        }

        int[] values = array.clone();
        Arrays.sort(values);

        if (values[0] != 1) {
            return 1;
        }

        int sum = values[0];
        for (int i = 1; i < values.length; i++) {
            if (sum + 1 < values[i]) {
                break;
            }

            sum += values[i];
        }

        return sum + 1;
    }

    public static void main(String[] args) {
        int[] array = readInput();
        System.out.println(calculate(array));
    }
}
