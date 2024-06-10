import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[] readInput() {
        int[] inputs;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return inputs;
    }

    private static int calculate(int[] inputs) {
        int[] array = new int[inputs.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        int max = 1;

        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inputs[j] < inputs[i]) {
                    array[i] = Math.max(array[i], array[j] + 1);
                }
            }
            max = Math.max(max, array[i]);
        }

        return max;
    }

    private static void run() {
        int[] inputs = readInput();
        System.out.println(calculate(inputs));
    }

    public static void main(String[] args) {
        run();
    }
}
