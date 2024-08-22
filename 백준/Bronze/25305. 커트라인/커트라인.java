import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            inputs = reader.readLine().split(" ");
            for (int i = 0; i < inputs.length; i++) {
                queue.add(Integer.parseInt(inputs[i]));
            }

            for (int i = 1; i < k; i++) {
                queue.poll();
            }

            System.out.println(queue.poll());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
