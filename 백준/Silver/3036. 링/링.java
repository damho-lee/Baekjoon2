import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int gcd;

            for (int i = 1; i < inputs.length; i++) {
                gcd = gcd(inputs[0], inputs[i]);
                writer.write(inputs[0] / gcd + "/" + inputs[i] / gcd);
                writer.newLine();
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int gcd(int x, int y) {
        int a = Math.max(x, y);
        int b = Math.min(x, y);
        int tmp;

        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }
}