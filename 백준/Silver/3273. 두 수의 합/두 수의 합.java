import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String input;
        int n;
        int[] numbers;
        int target;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().trim());
            numbers = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            target = Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(calculate(numbers, target));
    }

    private static int calculate(int[] array, int target) {
        int[] numbers = Arrays.copyOf(array, array.length);
        Arrays.sort(numbers);

        int left = 0;
        int right = array.length - 1;
        int count = 0;
        int sum;

        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                count++;
                left++;
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}