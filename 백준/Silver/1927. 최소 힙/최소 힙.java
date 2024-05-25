import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static PriorityQueue<Integer> queue = new PriorityQueue<>();

    private static int pop() {
        if (queue.isEmpty()) {
            return 0;
        }

        return queue.poll();
    }

    private static void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < size; i++) {
                int input = Integer.parseInt(reader.readLine().trim());
                if (input == 0) {
                    System.out.println(pop());
                } else {
                    queue.add(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        run();
    }
}
