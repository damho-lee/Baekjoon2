import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            System.out.println(solve(n));
        } catch (IOException e) {
        }
    }

    private static int solve(int n) {
        int count = 1;
        int x = calculate(n);

        while (x != n) {
            x = calculate(x);
            count++;
        }

        return count;
    }

    private static int calculate(int n) {
        return (n % 10) * 10 + (n / 10 + n % 10) % 10;
    }
}