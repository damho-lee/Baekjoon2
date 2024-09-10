import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] trees = new int[n];
            for (int i = 0; i < n; i++) {
                trees[i] = Integer.parseInt(reader.readLine().trim());
            }

            int gcd = 0;
            int distance;
            for (int i = 0; i < n - 1; i++) {
                distance = trees[i + 1] - trees[i];
                gcd = gcd(distance, gcd);
            }

            System.out.println((trees[n - 1] - trees[0]) / gcd + 1 - n);
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