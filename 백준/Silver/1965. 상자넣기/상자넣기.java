import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] boxes;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            boxes = new int[n];
            String[] inputs = reader.readLine().trim().split(" ");
            for (int i = 0; i < inputs.length; i++) {
                boxes[i] = Integer.parseInt(inputs[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int[] array = new int[boxes.length];
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = 1;

            for (int j = 0; j < i; j++) {
                if (boxes[i] > boxes[j]) {
                    array[i] = Math.max(array[i], array[j] + 1);
                }
            }

            max = Math.max(max, array[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
