import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");

            long n = Long.parseLong(inputs[0]);
            long r = Long.parseLong(inputs[1]);

            System.out.println(n + 1 + 2 * (r - 1));
        } catch (IOException e) {
        }
    }
}