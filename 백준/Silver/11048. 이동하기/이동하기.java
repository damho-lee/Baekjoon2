import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[][] array;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            array = new int[n][m];

            for (int i = 0; i < n; i++) {
                array[i] = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int[] dx = new int[]{-1, -1, 0};
        int[] dy = new int[]{0, -1, -1};
        int[][] dp = new int[array.length][array[0].length];
        dp[0][0] = array[0][0];

        for (int i = 0; i < dp.length; i++) {
            int max = 0;

            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < 3; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if (isValid(newX, newY)) {
                        max = Math.max(max, dp[newX][newY]);
                    }
                }

                dp[i][j] = max + array[i][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < array.length && y >= 0 && y < array[0].length;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
