import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            writer.write(gcd(a, b) + "\n");
            writer.write(lcm(a, b) + "");
        } catch (IOException e) {
        }
    }

    private static int gcd(int x, int y) {
        int a = x;
        int b = y;
        int c;

        while (b != 0) {
            c = a;
            a = b;
            b = c % a;
        }

        return a;
    }

    private static int lcm(int x, int y) {
        int a = x;
        int b = y;
        int gcd = gcd(a, b);

        return a * b / gcd;
    }
}