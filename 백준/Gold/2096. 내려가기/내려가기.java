import java.io.*;
import java.util.stream.Stream;

public class Main {
    private static int[][] board;
    private static int row;
    private static int column = 3;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            row = Integer.parseInt(reader.readLine().trim());
            board = new int[row][];

            for (int i = 0; i < row; i++) {
                board[i] = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calculate() {
        int[][] max = new int[row][column];
        int[][] min = new int[row][column];
        int[] delta = new int[]{-1, 0, 1};

        max[0][0] = board[0][0];
        max[0][1] = board[0][1];
        max[0][2] = board[0][2];
        min[0][0] = board[0][0];
        min[0][1] = board[0][1];
        min[0][2] = board[0][2];

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int maxValue = Integer.MIN_VALUE;
                int minValue = Integer.MAX_VALUE;

                for (int k = 0; k < delta.length; k++) {
                    int newY = j + delta[k];

                    if (isValid(newY)) {
                        maxValue = Math.max(maxValue, max[i - 1][newY]);
                        minValue = Math.min(minValue, min[i - 1][newY]);
                    }
                }

                max[i][j] = maxValue + board[i][j];
                min[i][j] = minValue + board[i][j];
            }
        }

        int maximum = Math.max(Math.max(max[row - 1][0], max[row - 1][1]), max[row - 1][2]);
        int minimum = Math.min(Math.min(min[row - 1][0], min[row - 1][1]), min[row - 1][2]);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            writer.write(maximum + " " + minimum);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isValid(int y) {
        return y >= 0 && y < column;
    }

    private static void run() {
        readInput();
        calculate();
    }

    public static void main(String[] args) {
        run();
    }
}
