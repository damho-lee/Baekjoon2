import java.io.*;

public class Main {
    private static int[] inputs;
    private static long[] sequence;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCase = Integer.parseInt(reader.readLine().trim());
            inputs = new int[testCase];
            int max = 4;

            for (int i = 0; i < testCase; i++) {
                inputs[i] = Integer.parseInt(reader.readLine().trim());
                max = Math.max(inputs[i], max);
            }

            sequence = new long[max + 1];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calculate() {
        for (int i = 0; i < 4; i++) {
            sequence[i] = 1;
        }

        for (int i = 4; i < sequence.length; i++) {
            sequence[i] = sequence[i - 3] + sequence[i - 2];
        }
    }

    private static void print() {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < inputs.length; i++) {
                writer.write(sequence[inputs[i]] + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        readInput();
        calculate();
        print();
    }

    public static void main(String[] args) {
        run();
    }
}
