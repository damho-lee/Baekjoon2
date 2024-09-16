import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            MyStack stack = new MyStack();
            int n = Integer.parseInt(reader.readLine().trim());
            int command;
            String[] inputs;
            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                command = Integer.parseInt(inputs[0]);
                switch (command) {
                    case 1:
                        stack.push(Integer.parseInt(inputs[1]));
                        break;
                    case 2:
                        writer.write(stack.pop() + "\n");
                        break;
                    case 3:
                        writer.write(stack.size() + "\n");
                        break;
                    case 4:
                        writer.write(stack.isEmpty() + "\n");
                        break;
                    case 5:
                        writer.write(stack.peek() + "\n");
                        break;
                    default:
                        throw new IllegalArgumentException("1에서 5사이의 값을 입력하세요");
                }

                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyStack {
    private Stack<Integer> stack;

    public MyStack() {
        this.stack = new Stack<>();
    }

    public int isEmpty() {
        if (this.stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void push(int n) {
        this.stack.push(n);
    }

    public int pop() {
        if (this.isEmpty() == 1) {
            return -1;
        } else {
            return this.stack.pop();
        }
    }

    public int peek() {
        if (this.isEmpty() == 1) {
            return -1;
        } else {
            return this.stack.peek();
        }
    }

    public int size() {
        return this.stack.size();
    }
}