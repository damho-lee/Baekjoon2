import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int input;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 5; i++) {
                input = Integer.parseInt(reader.readLine().trim());
                sum += input;
                queue.add(input);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum / 5);
        queue.poll();
        queue.poll();
        System.out.println(queue.poll());
    }
}
