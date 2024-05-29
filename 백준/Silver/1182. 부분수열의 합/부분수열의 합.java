import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[] array;
    private static int n;
    private static int s;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            n = Integer.parseInt(inputs[0]);
            s = Integer.parseInt(inputs[1]);

            array = new int[n];
            array = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int index, int sum) {
        if (index == n) {
            if (sum == s) {
                return 1;
            }

            return 0;
        }

        return calculate(index + 1, sum) + calculate(index + 1, sum + array[index]);
    }

    private static void run() {
        readInput();
        int result = s == 0 ? calculate(0, 0) - 1 : calculate(0, 0);
        System.out.println(result);
    }

    public static void main(String[] args) {
        run();
    }
}
