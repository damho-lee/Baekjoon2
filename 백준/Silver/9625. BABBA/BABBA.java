import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calculate(int k) {
        int[][] array = new int[k + 1][2];
        array[0][0] = 1;
        array[0][1] = 0;
        array[1][0] = 0;
        array[1][1] = 1;

        for (int i = 2; i < array.length; i++) {
            array[i][0] = array[i - 1][1];
            array[i][1] = array[i - 1][0] + array[i - 1][1];
        }

        System.out.println(array[k][0] + " " + array[k][1]);
    }

    public static void main(String[] args) {
        int k = readInput();
        calculate(k);
    }
}
