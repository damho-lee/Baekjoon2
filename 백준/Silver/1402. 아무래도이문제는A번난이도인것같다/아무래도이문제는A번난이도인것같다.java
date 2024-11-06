import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            String input = reader.readLine().trim();

            for (int i = 0; i < n; i++) {
                writer.write("yes\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}