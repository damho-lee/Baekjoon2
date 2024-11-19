import java.io.*;

public class Main {
    private static final long DIVISOR = 1_000_000_007L;
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            long x = 1;
            long y = 1;
            long z = 0;

            for (int i = 3; i <= n; i++) {
                z = (x + y) % DIVISOR;
                x = y;
                y = z;
            }

            System.out.println(z + " " + (n - 2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}