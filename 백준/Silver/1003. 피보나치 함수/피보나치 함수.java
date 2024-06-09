import java.io.*;

public class Main {
    private static int max;
    private static int inputs[];

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            inputs = new int[n];
            max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(reader.readLine().trim());
                max = Math.max(input, max);
                inputs[i] = input;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] calculate() {
        int[][] array = new int[max + 1][2];
        array[0][0] = 1;
        array[0][1] = 0;

        for (int i = 1; i < array.length; i++) {
            array[i][0] = array[i - 1][1];
            array[i][1] = array[i - 1][0] + array[i - 1][1];
        }

        return array;
    }

    private static void print(int[][] array) {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int index : inputs) {
                stringBuffer.append(array[index][0]).append(" ").append(array[index][1]).append("\n");
            }

            writer.write(stringBuffer.toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        readInput();
        int[][] result = calculate();
        print(result);
    }

    public static void main(String[] args) {
        run();
    }
}
