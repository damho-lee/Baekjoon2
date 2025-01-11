import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(inputs);
            int result = 0;
            int sum = inputs[0];

            for (int i = 1; i < n; i++) {
                result += sum * inputs[i];
                sum += inputs[i];
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}