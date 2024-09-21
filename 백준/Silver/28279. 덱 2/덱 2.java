import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            MyDeque deque = new MyDeque();
            int n = Integer.parseInt(reader.readLine().trim());
            String[] inputs;
            int command;

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                command = Integer.parseInt(inputs[0]);

                switch (command) {
                    case 1:
                        deque.addFirst(Integer.parseInt(inputs[1]));
                        break;
                    case 2:
                        deque.addLast(Integer.parseInt(inputs[1]));
                        break;
                    case 3:
                        writer.write(deque.pollFirst() + "\n");
                        break;
                    case 4:
                        writer.write(deque.pollLast() + "\n");
                        break;
                    case 5:
                        writer.write(deque.size() + "\n");
                        break;
                    case 6:
                        writer.write(deque.isEmpty() + "\n");
                        break;
                    case 7:
                        writer.write(deque.peekFirst() + "\n");
                        break;
                    case 8:
                        writer.write(deque.peekLast() + "\n");
                        break;
                    default:
                        throw new IllegalArgumentException("해당 명령어(" + command + ")는 지원되지 않습니다.");
                }
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyDeque {
    private final Deque<Integer> deque;

    public MyDeque() {
        this.deque = new LinkedList<>();
    }

    public void addFirst(int n) {
        deque.addFirst(n);
    }

    public void addLast(int n) {
        deque.addLast(n);
    }

    public int pollFirst() {
        return deque.isEmpty() ? -1 : deque.pollFirst();
    }

    public int pollLast() {
        return deque.isEmpty() ? -1 : deque.pollLast();
    }

    public int size() {
        return deque.size();
    }

    public int isEmpty() {
        return deque.isEmpty() ? 1 : 0;
    }

    public int peekFirst() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public int peekLast() {
        return deque.isEmpty() ? -1 : deque.peekLast();
    }
}