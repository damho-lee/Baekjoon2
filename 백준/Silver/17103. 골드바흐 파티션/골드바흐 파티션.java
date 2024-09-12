import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            boolean[] isPrime = new boolean[1000000];
            initPrimeArray(isPrime);

            int n = Integer.parseInt(reader.readLine().trim());
            int input;
            int count;
            for (int i = 0; i < n; i++) {
                input = Integer.parseInt(reader.readLine().trim());
                count = 0;

                if (input % 2 == 0) {
                    for (int j = 2; j <= input / 2; j++) {
                        if (isPrime[j] && isPrime[input - j]) {
                            count++;
                        }
                    }
                }

                writer.write(count + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initPrimeArray(boolean[] array) {
        Arrays.fill(array, true);

        for (int i = 2; i < array.length; i++) {
            for (int j = 2; i * j < array.length; j++) {
                array[i * j] = false;
            }
        }
    }
}