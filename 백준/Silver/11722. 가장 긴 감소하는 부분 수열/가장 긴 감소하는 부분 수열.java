import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    private static int[] inputs;
    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int[] count = new int[inputs.length];
        Arrays.fill(count, 1);
        int max = 0;

        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inputs[i] < inputs[j]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
            max = Math.max(max, count[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
