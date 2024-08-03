import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int b;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine().trim());
            n = Integer.parseInt(stringTokenizer.nextToken());
            b = Integer.parseInt(stringTokenizer.nextToken());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String transfer() {
        StringBuffer stringBuffer = new StringBuffer();
        int number = n;
        int remainder = 0;

        while (number > 0) {
            remainder = number % b;

            if (remainder < 10) {
                stringBuffer.append(remainder);
            } else {
                stringBuffer.append((char) ('A' + remainder - 10));
            }

            number /= b;
        }

        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(transfer());
    }
}
