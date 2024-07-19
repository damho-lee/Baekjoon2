import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[] inputs;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int[] up = new int[inputs.length];
        int[] down = new int[inputs.length];
        int max = 1;
        int min = 1;

        int maxCount = 1;

        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i] >= inputs[i - 1]) {
                max++;
            } else {
                max = 1;
            }

            maxCount = Math.max(max, maxCount);
        }

        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i] <= inputs[i - 1]) {
                min++;
            } else {
                min = 1;
            }

            maxCount = Math.max(min, maxCount);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
