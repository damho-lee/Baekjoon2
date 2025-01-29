import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            
            for (int i = 1; i < 10; i++) {
                writer.write(String.format("%d * %d = %d\n", n, i, n * i));
            }
            
            writer.flush();
        } catch (IOException e) {
        }
    }
}