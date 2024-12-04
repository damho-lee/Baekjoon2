import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(Solution.calculate(inputs));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    public static int calculate(int[] inputs) {
        int[] boxes = inputs.clone();
        int[] dp = new int[boxes.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < boxes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[i] > boxes[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(0);
    }
}