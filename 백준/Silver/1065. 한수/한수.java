import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            writer.write(calculate(n) + "");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int n) {
        if (n < 100) {
            return n;
        }
        int x, y, z;

        int count = 99;
        for (int i = 111; i <= n; i++) {
            x = i / 100;
            y = i / 10 % 10;
            z = i % 10;

            if ((x - y) == (y - z)) {
                count++;
            }
        }

        return count;
    }
}