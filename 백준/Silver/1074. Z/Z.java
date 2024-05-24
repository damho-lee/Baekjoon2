import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int r;
    private static int c;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            n = Integer.parseInt(inputs[0].trim());
            r = Integer.parseInt(inputs[1].trim());
            c = Integer.parseInt(inputs[2].trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int size = (int) Math.pow(2, n);
        int count = 0;
        int x = 0;
        int y = 0;
        while (size > 1) {
            size /= 2;

            if (r < x + size && c >= y + size) {
                count += (int) Math.pow(size * 2, 2) / 4;
                y += size;
            } else if (r >= x + size && c < y + size) {
                count += (int) Math.pow(size * 2, 2) / 4 * 2;
                x += size;
            } else if (r >= x + size && c >= y + size) {
                count += (int) Math.pow(size * 2, 2) / 4 * 3;
                x += size;
                y += size;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
