import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int side1;
    private static int side2;
    private static int max;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            if (a > b && a > c) {
                max = a;
                side1 = b;
                side2 = c;
            } else if (b > a && b > c) {
                max = b;
                side1 = a;
                side2 = c;
            } else {
                max = c;
                side1 = a;
                side2 = b;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        if (max >= side1 + side2) {
            return (side1 + side2) * 2 - 1;
        } else {
            return max + side1 + side2;
        }
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
