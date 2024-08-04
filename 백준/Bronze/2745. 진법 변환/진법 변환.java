import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static String input;
    private static int b;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine().trim());
            input = stringTokenizer.nextToken();
            b = Integer.parseInt(stringTokenizer.nextToken());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int transfer() {
        int result = 0;
        int base = 1;
        for (int i = input.length() - 1; i >= 0; i--) {
            char current = input.charAt(i);
            if (current >= 'A' && current <= 'Z') {
                result += (current - 'A' + 10) * base;
            } else {
                result += (current - '0') * base;
            }

            base *= b;
        }

        return result;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(transfer());
    }
}
