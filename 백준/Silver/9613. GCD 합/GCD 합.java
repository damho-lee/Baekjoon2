import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] inputs;
            for (int i = 0; i < n; i++) {
                inputs = Stream.of(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                long result = 0;

                for (int j = 1; j < inputs.length; j++) {
                    for (int k = j + 1; k < inputs.length; k++) {
                        result += Mathx.gcd(inputs[j], inputs[k]);
                    }
                }

                writer.write(result + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Mathx {
    private Mathx() {
    }

    public static int gcd(int a, int b) {
        int x = a;
        int y = b;
        int tmp;

        while (y > 0) {
            tmp = y;
            y = x % y;
            x = tmp;
        }

        return x;
    }
}