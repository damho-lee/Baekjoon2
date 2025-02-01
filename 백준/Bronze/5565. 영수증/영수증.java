import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int total = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < 9; i++) {
                total -= Integer.parseInt(reader.readLine().trim());
            }

            System.out.println(total);
        } catch (IOException e) {
        }
    }
}