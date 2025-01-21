import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            int[] inputs = new int[n];
            int[] answers = new int[n];
            int sum = 0;

            for (int i = 0; i < n; i++) {
                inputs[i] = Integer.parseInt(reader.readLine().trim());

                if (i % 2 == 0) {
                    sum += inputs[i];
                } else {
                    sum -= inputs[i];
                }
            }

            answers[0] = sum / 2;

            for (int i = 1; i < n; i++) {
                answers[i] = inputs[i - 1] - answers[i - 1];
            }

            Arrays.stream(answers).forEach(System.out::println);
        } catch (IOException e) {
        }
    }
}