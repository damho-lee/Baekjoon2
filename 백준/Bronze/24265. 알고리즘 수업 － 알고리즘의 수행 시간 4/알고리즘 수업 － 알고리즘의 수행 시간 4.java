import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long n = Long.parseLong(reader.readLine().trim());
            long result = 0;
            for (long i = 1; i < n; i ++) {
                result += i;
            }
            System.out.println(result);
            System.out.println(2);
        } catch (IOException e) {
        }
    }
}
