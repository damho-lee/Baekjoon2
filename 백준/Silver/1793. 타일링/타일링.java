import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> inputs;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputs = new ArrayList<>();
            String input;

            while((input = reader.readLine()) != null) {
                int n = Integer.parseInt(input);
                inputs.add(n);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        StringBuffer stringBuffer = new StringBuffer();

        BigInteger[] array = new BigInteger[251];
        array[0] = BigInteger.ONE;
        array[1] = BigInteger.ONE;
        array[2] = BigInteger.valueOf(3L);

        for (int i = 3; i < array.length; i++) {
            array[i] = array[i - 1].add(array[i - 2].multiply(BigInteger.TWO));
        }

        for (Integer i : inputs) {
            stringBuffer.append(array[i]);
            stringBuffer.append("\n");
        }

        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        readInput();
        run();
    }
}
