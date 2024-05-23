import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[][] triangle;

    private static int[][] readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine().trim());

            triangle = new int[size][];

            for (int i = 0; i < size; i++) {
                triangle[i] = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            return triangle;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print() {
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int calculate() {
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int max = 0;
                if (isValid(i - 1, j - 1)) {
                    max = Math.max(max, triangle[i - 1][j - 1]);
                }

                if (isValid(i - 1, j)) {
                    max = Math.max(max, triangle[i - 1][j]);
                }

                triangle[i][j] += max;
            }
        }

        int max = 0;

        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            max = Math.max(max, triangle[triangle.length - 1][i]);
        }

        return max;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < triangle.length && y >= 0 && y < triangle[x].length;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
