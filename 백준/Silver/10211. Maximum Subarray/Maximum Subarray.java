import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] array;

            for (int i = 0; i < n; i++) {
                int sizeOfArray = Integer.parseInt(reader.readLine().trim());
                array = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                writer.write(Solution.calculate(array) + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    public static int calculate(int[] array) {
        int[] dp = new int[array.length];

        int max = array[0];
        dp[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}