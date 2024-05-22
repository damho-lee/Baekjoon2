import java.io.*;
import java.util.stream.Stream;

public class Main {
    private static int[][][] dp = new int[21][21][21];

    private static int[] readInput(BufferedReader reader) throws IOException {
        return Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int w(int a, int b, int c) {
        if (isValid(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <=0) {
            return 1;
        }

        if(a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        if(a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    private static boolean isValid(int a, int b, int c) {
        return a >= 0 && a < 21 && b >= 0 && b < 21 && c >= 0 && c < 21;
    }

    private static void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int[] array;
            while (true) {
                array = readInput(reader);
                if (array[0] == -1 && array[1] == -1 && array[2] == -1) {
                    break;
                }

                writer.write("w(" + array[0] + ", " + array[1] + ", " + array[2] + ") = " + w(array[0], array[1], array[2]) + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        run();
    }
}
