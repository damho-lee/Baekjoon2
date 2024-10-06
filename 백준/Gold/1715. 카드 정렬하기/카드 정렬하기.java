import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
        int size;
        int result = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            size = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < size; i++) {
                pq.add(Integer.parseInt(reader.readLine().trim()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < size - 1; i++) {
            int x = 0;
            int y = 0;
            if (!pq.isEmpty()) {
                x = pq.poll();
            }
            if (!pq.isEmpty()) {
                y = pq.poll();
            }

            result += x + y;
            pq.offer(x + y);
        }

        System.out.println(result);
    }
}