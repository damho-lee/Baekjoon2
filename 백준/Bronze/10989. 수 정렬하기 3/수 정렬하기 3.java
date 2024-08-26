import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] array = new int[10000001];
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(reader.readLine().trim());
                array[input]++;
            }

            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array[i]; j++) {
                    writer.write(i + "\n");
                }
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
