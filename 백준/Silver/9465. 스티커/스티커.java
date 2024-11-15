import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[][] input;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int lengthOfColumn;

            for (int i = 0; i < n; i++) {
                lengthOfColumn = Integer.parseInt(reader.readLine().trim());
                input = new int[2][lengthOfColumn];

                for (int j = 0; j < 2; j++) {
                    input[j] = makeArray(reader);
                }

                writer.write(Solution.simulate(input) + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] makeArray(BufferedReader reader) throws IOException {
        return Stream.of(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

class Solution {
    private Solution() {
    }

    public static int simulate(int[][] graph) {
        int lengthOfColumn = graph[0].length;

        if (lengthOfColumn == 1) {
            return Math.max(graph[0][0], graph[1][0]);
        }

        int[][] dp = new int[graph.length][graph[0].length];

        dp[0][0] = graph[0][0];
        dp[1][0] = graph[1][0];
        dp[0][1] = dp[1][0] + graph[0][1];
        dp[1][1] = dp[0][0] + graph[1][1];

        for (int column = 2; column < lengthOfColumn; column++) {
            dp[0][column] = Math.max(Math.max(dp[0][column - 2], dp[1][column - 2]), dp[1][column - 1]) + graph[0][column];
            dp[1][column] = Math.max(Math.max(dp[0][column - 2], dp[1][column - 2]), dp[0][column - 1]) + graph[1][column];
        }

        return Math.max(dp[0][lengthOfColumn - 1], dp[1][lengthOfColumn - 1]);
    }
}
