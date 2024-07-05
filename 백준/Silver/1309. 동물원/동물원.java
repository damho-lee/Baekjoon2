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

    private static int calculate(int n) {
        int[][] array = new int[n + 1][3];

        array[1][0] = array[1][1] = array[1][2] = 1;

        for (int i = 2; i < array.length; i++) {
            array[i][0] = (array[i - 1][0] + array[i - 1][1] + array[i - 1][2]) % 9901;
            array[i][1] = (array[i - 1][0] + array[i - 1][2]) % 9901;
            array[i][2] = (array[i - 1][0] + array[i - 1][1]) % 9901;
        }

        return (array[n][0] + array[n][1] + array[n][2]) % 9901;
    }

    public static void main(String[] args) {
        int n = readInput();
        System.out.println(calculate(n));
    }
}
