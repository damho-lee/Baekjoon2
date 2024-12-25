import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] numbers = new int[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(reader.readLine().trim());
            }

            Arrays.sort(numbers);

            for (int i = numbers.length - 3; i >= 0; i--) {
                if (numbers[i] + numbers[i + 1] > numbers[i + 2]) {
                    System.out.println(numbers[i] + numbers[i + 1] + numbers[i + 2]);
                    return;
                }
            }

            System.out.println(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
