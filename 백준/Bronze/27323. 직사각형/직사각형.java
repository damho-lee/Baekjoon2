import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int width;
        int height;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            width = Integer.parseInt(reader.readLine().trim());
            height = Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(width * height);
    }
}
