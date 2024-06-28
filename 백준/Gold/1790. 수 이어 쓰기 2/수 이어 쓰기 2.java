import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int k;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            k = Integer.parseInt(inputs[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String calculate() {
        long numberLength = 1;
        long numberCount = 9;
        long newK = k;
        long target = 0;

        while (newK > numberLength * numberCount) {
            newK -= numberLength * numberCount;
            target += numberCount;

            numberLength++;
            numberCount *= 10;
        }

        target = (target + 1) + (newK - 1) / numberLength;

        if (target > n) {
            return "-1";
        } else {
            int index = (int) ((newK - 1) % numberLength);
            return String.valueOf(String.valueOf(target).charAt(index));
        }
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
