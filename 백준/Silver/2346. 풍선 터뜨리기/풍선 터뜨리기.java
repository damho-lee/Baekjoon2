import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Deque<Balloon> deque = new ArrayDeque<>();
            int n = Integer.parseInt(reader.readLine());
            String[] inputs = reader.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                deque.add(new Balloon(i + 1, Integer.parseInt(inputs[i])));
            }

            Balloon current = deque.pollFirst();
            int delta = current.getDelta();
            writer.write(current.getNumber() + " ");

            while (!deque.isEmpty()) {
                if (delta > 0) {
                    for (int i = 0; i < delta - 1; i++) {
                        deque.addLast(deque.pollFirst());
                    }
                    current = deque.pollFirst();
                } else {
                    for (int i = 0; i < Math.abs(delta) - 1; i++) {
                        deque.addFirst(deque.pollLast());
                    }
                    current = deque.pollLast();
                }

                delta = current.getDelta();
                writer.write(current.getNumber() + " ");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Balloon {
    private final int number;
    private final int delta;

    public Balloon(int number, int delta) {
        this.number = number;
        this.delta = delta;
    }

    public int getNumber() {
        return number;
    }

    public int getDelta() {
        return delta;
    }
}