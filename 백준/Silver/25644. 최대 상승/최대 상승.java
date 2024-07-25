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
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < inputs.length; i++) {
            int current = inputs[i];

            result = Math.max(result, current - min);
            min = Math.min(min, current);
        }

        return result;
    }

    private static void run() {
        readInput();
        System.out.println(calculate());
    }

    public static void main(String[] args) {
        run();
    }
}
