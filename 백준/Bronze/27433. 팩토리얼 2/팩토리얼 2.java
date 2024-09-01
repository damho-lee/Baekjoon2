import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            System.out.println(factorial(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long factorial(long n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}