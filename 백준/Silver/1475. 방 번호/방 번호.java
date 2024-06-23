import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int run(String input) {
        int[] number = new int[10];
        for (int i = 0; i < input.length(); i++) {
            int n = input.charAt(i) - '0';

            if (n == 6 || n == 9) {
                if (number[6] > number[9]) {
                    number[9]++;
                } else {
                    number[6]++;
                }
            } else {
                number[n]++;
            }
        }

        int max = 0;
        for (int i = 0; i < number.length; i++) {
            max = Math.max(max, number[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        String input = readInput();
        System.out.println(run(input));
    }
}
