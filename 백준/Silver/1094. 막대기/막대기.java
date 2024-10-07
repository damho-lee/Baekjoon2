import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    private static final int INIT_VALUE = 64;

    public static void main(String[] args) {
        int x;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            x = Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(calculate(x));
    }

    private static int calculate(int x) {
        int[] subSticks = IntStream.iterate(INIT_VALUE, n -> n > 0, n -> n / 2).toArray();
        int result = 0;
        int count = 0;

        for (int subStick : subSticks) {
            if (result + subStick <= x) {
                result += subStick;
                count++;
            }

            if (result == x) {
                break;
            }
        }

        return count;
    }
}