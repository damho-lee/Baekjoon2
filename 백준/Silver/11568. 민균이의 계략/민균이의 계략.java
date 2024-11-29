import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(Solution.solve(inputs));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    public static int solve(int[] inputs) {
        int[] numbers = inputs.clone();
        int[] array = new int[numbers.length];
        array[0] = numbers[0];
        int length = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (array[length] < numbers[i]) {
                array[length + 1] = numbers[i];
                length++;
            } else {
                int newIndex = binarySearch(0, length, numbers[i], array);
                array[newIndex] = numbers[i];
            }
        }

        return length + 1;
    }

    private static int binarySearch(int left, int right, int target, int[] array) {
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}