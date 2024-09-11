import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            long input;
            for (int i = 0; i < n; i++) {
                input = Long.parseLong(reader.readLine().trim());
                while (true) {
                    if (isPrime(input)) {
                        writer.write(input + "\n");
                        break;
                    }

                    input++;
                }
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isPrime(long x) {
        if (x == 0 || x == 1) {
            return false;
        }

        for (long l = 2; l <= Math.sqrt(x); l++) {
            if (x % l == 0) {
                return false;
            }
        }

        return true;
    }
}