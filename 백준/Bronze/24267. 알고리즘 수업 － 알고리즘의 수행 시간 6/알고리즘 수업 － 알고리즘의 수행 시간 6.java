import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long n = Long.parseLong(reader.readLine().trim());
            System.out.println(n * (n - 1) * (n - 2) / 6);
            System.out.println(3);
        } catch (IOException e) {
        }
    }
}
