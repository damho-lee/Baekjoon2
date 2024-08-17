import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int target = Integer.parseInt(inputs[1]);
            int[] array = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        sum = array[i] + array[j] + array[k];
                        if (sum <= target && sum > max) {
                            max = sum;
                        }
                    }
                }
            }
            System.out.println(max);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
