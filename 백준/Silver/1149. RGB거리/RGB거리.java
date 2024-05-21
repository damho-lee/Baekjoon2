import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[][] readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] array = new int[n][3];

            for (int i = 0; i < n; i++) {
                int[] inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                array[i][0] = inputs[0];
                array[i][1] = inputs[1];
                array[i][2] = inputs[2];
            }

            return array;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int[][] array) {
        int red = 0;
        int green = 1;
        int blue = 2;
        int[][] cost = new int[array.length][array[0].length];

        cost[0][0] = array[0][0];
        cost[0][1] = array[0][1];
        cost[0][2] = array[0][2];

        for (int i = 1; i < array.length; i++) {
            cost[i][red] = Math.min(cost[i - 1][green], cost[i - 1][blue]) + array[i][red];
            cost[i][green] = Math.min(cost[i - 1][red], cost[i - 1][blue]) + array[i][green];
            cost[i][blue] = Math.min(cost[i - 1][red], cost[i - 1][green]) + array[i][blue];
        }

        return Math.min(Math.min(cost[cost.length - 1][red], cost[cost.length - 1][green]), cost[cost.length - 1][blue]);
    }

    public static void main(String[] args) {
        int[][] array = readInput();
        System.out.println(calculate(array));
    }
}
