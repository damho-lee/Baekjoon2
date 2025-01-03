import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int d = Integer.parseInt(inputs[2]);

            System.out.println(calculate(a, b, d));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculate(int start, int end, int number) {
        int result = 0;
        String target = String.valueOf(number);

        for (int i = start; i <= end; i++) {
            if (isPrime(i) && String.valueOf(i).contains(target)) {
                result++;
            }
        }

        return result;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}