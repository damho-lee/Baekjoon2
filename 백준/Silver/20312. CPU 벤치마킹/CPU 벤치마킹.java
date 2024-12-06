import java.io.*;
import java.util.stream.Stream;

public class Main {
    private static final int DIVISOR = 1_000_000_007;
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] results = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long answer = 0;
            long previous = 0;

            for (int r : results) {
                previous = (previous + 1) * r % DIVISOR;
                answer = (answer + previous) % DIVISOR;
            }

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}