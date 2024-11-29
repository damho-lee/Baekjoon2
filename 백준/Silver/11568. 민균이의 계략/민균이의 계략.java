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
        int[] length = new int[numbers.length];
        Arrays.fill(length, 1);
        int max = 0;

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
        }

        return Arrays.stream(length).max().orElse(1);
    }
}