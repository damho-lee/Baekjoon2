import java.io.*;

public class Main {
    public static void main(String[] args) {
        int count = 2;
        int n;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                count = count + count - 1;
            }
            count = count * count;
            writer.write((Integer.toString(count)));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
