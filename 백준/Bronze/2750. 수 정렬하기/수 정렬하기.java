import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
            for (int i = 0; i < n; i++) {
                queue.add(Integer.parseInt(reader.readLine().trim()));
            }

            while(!queue.isEmpty()) {
                writer.write(queue.poll() + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
