import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, true);
            int count = 0;

            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= n; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        count++;
                    }

                    if (count == k) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
