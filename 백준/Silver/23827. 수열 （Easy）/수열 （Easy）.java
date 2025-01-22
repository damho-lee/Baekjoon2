import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    private static final int DIVISOR = 1_000_000_007;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            long[] array = Stream.of(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long sum = Arrays.stream(array).sum();
            long result = 0;

            for (int i = 0; i < array.length; i++) {
                sum -= array[i];
                result = (result + sum * array[i] % DIVISOR) % DIVISOR;
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}