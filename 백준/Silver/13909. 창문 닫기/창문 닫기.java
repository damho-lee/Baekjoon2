import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int count = 0;

            for (int i = 1; i * i <= n; i++) {
                count++;
            }

            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}