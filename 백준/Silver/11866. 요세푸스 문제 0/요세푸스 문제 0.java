import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int count = Integer.parseInt(inputs[1]);
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                queue.offer(i + 1);
            }

            writer.write("<");
            for (int i = 0; i < count - 1; i++) {
                queue.offer(queue.poll());
            }

            writer.write(queue.poll() + "");
            while (!queue.isEmpty()) {
                writer.write(", ");
                for (int i = 0; i < count - 1; i++) {
                    queue.offer(queue.poll());
                }

                writer.write(queue.poll() + "");
            }
            writer.write(">");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}