import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] inputs;
            int x;
            int y;
            int gcd;

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                x = Integer.parseInt(inputs[0]);
                y = Integer.parseInt(inputs[1]);
                gcd = gcd(x, y);

                writer.write(x * y / gcd + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        int r;

        while (y != 0) {
            r = x % y;
            x = y;
            y = r;
        }

        return x;
    }
}