import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] inputs = reader.readLine().split(" ");
            Queue<Integer> queue = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            int current = 1;
            int person;
            for (int i = 0; i < n; i++) {
                queue.add(Integer.parseInt(inputs[i]));
            }

            while (!queue.isEmpty()) {
                person = queue.peek();

                if (!stack.isEmpty() && stack.peek() == current) {
                    stack.pop();
                    current++;
                    continue;
                }

                if (person == current) {
                    queue.poll();
                    current++;
                    continue;
                }

                stack.push(queue.poll());
            }

            while (!stack.isEmpty()) {
                if (stack.pop() != current++) {
                    System.out.println("Sad");
                    return;
                }
            }

            System.out.println("Nice");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}