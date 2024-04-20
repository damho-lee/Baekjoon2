import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] values = new int[n];

            String[] inputs = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(inputs[i]);
            }

            return values;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int[] array) {
        if (array.length < 3) {
            return 0;
        }

        int count = 0;
        int[] values = array.clone();

        Arrays.sort(values);
        for (int i = 0; i < values.length; i++) {
            int target = values[i];
            int left = 0;
            int right = values.length - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = values[left] + values[right];
                if (target < sum) {
                    right--;
                } else if (target > sum) {
                    left++;
                } else {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = readInput();
        System.out.println(calculate(array));
    }
}
