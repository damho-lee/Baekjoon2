import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(":");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int gcd = gcd(n, m);

            System.out.println(n / gcd + ":" + m / gcd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int gcd(int n, int m) {
        int x = Math.max(n, m);
        int y = Math.min(n, m);
        int tmp;

        while (y != 0) {
            tmp = x % y;
            x = y;
            y = tmp;
        }

        return x;
    }
}