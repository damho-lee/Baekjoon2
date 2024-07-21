import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static double[] inputs;
    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            inputs = new double[n];

            for (int i = 0; i < n; i++) {
                inputs[i] = Double.parseDouble(reader.readLine().trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static double calculate() {
        double max = inputs[0];
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i] < inputs[i - 1] * inputs[i]) {
                inputs[i] = inputs[i] * inputs[i - 1];
            }
            max = Math.max(max, inputs[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        readInput();
        System.out.printf("%.3f", calculate());
    }
}
