import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            long x = Integer.parseInt(inputs[0]);
            long y = Integer.parseInt(inputs[1]);
            long gcd = gcd(x, y);
            writer.write(x * y / gcd + "");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long gcd(long a, long b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        long x = Math.max(a, b);
        long y = Math.min(a, b);
        long r;

        while (y != 0) {
            r = x % y;
            x = y;
            y = r;
        }

        return x;
    }
}