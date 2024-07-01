import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] array;
    private static int[][] range;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            array = new int[n + 1][n + 1];
            range = new int[m][4];
            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                int sum = 0;
                for (int j = 0; j < inputs.length; j++) {
                    sum += Integer.parseInt(inputs[j]);
                    array[i + 1][j + 1] = sum;
                }
            }

            for (int i = 0; i < m; i++) {
                inputs = reader.readLine().split(" ");
                int x1 = Integer.parseInt(inputs[0]);
                int y1 = Integer.parseInt(inputs[1]);
                int x2 = Integer.parseInt(inputs[2]);
                int y2 = Integer.parseInt(inputs[3]);
                range[i][0] = x1;
                range[i][1] = y1;
                range[i][2] = x2;
                range[i][3] = y2;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String calculate() {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < range.length; i++) {
            int sum = 0;
            int x1 = range[i][0];
            int y1 = range[i][1];
            int x2 = range[i][2];
            int y2 = range[i][3];

            for (int j = x1; j <= x2; j++) {
                sum += array[j][y2];
                sum -= array[j][y1 - 1];
            }

            stringBuffer.append(sum);
            stringBuffer.append("\n");
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
