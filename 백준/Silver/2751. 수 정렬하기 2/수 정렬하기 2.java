import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                queue.add(Integer.parseInt(reader.readLine().trim()));
            }

            for (int i = 0; i < n; i++) {
                writer.write(queue.poll() + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
