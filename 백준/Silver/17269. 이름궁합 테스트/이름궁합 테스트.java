import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int[] scores = new int[]{3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) {
        String[] inputs;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputs = reader.readLine().split(" ");
            int lengthOfName1 = Integer.parseInt(inputs[0]);
            int lengthOfName2 = Integer.parseInt(inputs[1]);

            inputs = reader.readLine().split(" ");
            char[] name1 = inputs[0].toCharArray();
            char[] name2 = inputs[1].toCharArray();

            int[] numbers = new int[lengthOfName1 + lengthOfName2];
            int min = Math.min(lengthOfName1, lengthOfName2);

            int current = 0;
            for (int i = 0; i < min; i++) {
                numbers[current++] = scores[name1[i] - 'A'];
                numbers[current++] = scores[name2[i] - 'A'];
            }

            char[] rest = lengthOfName1 > lengthOfName2 ? name1 : name2;
            for (int i = min; i < rest.length; i++) {
                numbers[current++] = scores[rest[i] - 'A'];
            }

            int sumOfLength = lengthOfName1 + lengthOfName2;
            while (sumOfLength > 2) {
                for (int i = 0; i < sumOfLength - 1; i++) {
                    numbers[i] = (numbers[i] + numbers[i + 1]) % 10;
                }

                sumOfLength--;
            }

            String result = numbers[0] == 0 ? String.valueOf(numbers[1]) : String.valueOf(numbers[0]).concat(String.valueOf(numbers[1]));
            System.out.println(result.concat("%"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}