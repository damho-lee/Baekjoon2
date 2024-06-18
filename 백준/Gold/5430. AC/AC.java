import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCase = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < testCase; i++) {
                Solution solution = new Solution(reader);
                writer.write(solution.solve());
                writer.write("\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        run();
    }
}

class Solution {
    private String method;
    private Deque<String> deque;
    private boolean isReversed;

    public Solution(BufferedReader reader) throws IOException {
        method = reader.readLine().trim();
        int arraySize = Integer.parseInt(reader.readLine().trim());
        parsing(reader.readLine(), arraySize);
    }

    private void parsing(String input, int arraySize) {
        String parenthesesDeletedInput = input.substring(1, input.length() - 1);
        String[] dividedInput = parenthesesDeletedInput.length() > 0 ? parenthesesDeletedInput.split(",") : new String[0];
        deque = new LinkedList<>();
        if (dividedInput.length != arraySize) {
            throw new IllegalArgumentException("배열에 들어있는 수가 다릅니다.(n = " + arraySize + ", 실제 들어있는 개수 = " + dividedInput.length + ")");
        }

        for (String s : dividedInput) {
            deque.add(s);
        }
    }

    public String solve() {
        for (int i = 0; i < method.length(); i++) {
            if (method.charAt(i) == 'R') {
                operationR();
            } else {
                try {
                    operationD();
                } catch (IllegalStateException e) {
                    return "error";
                }
            }
        }

        return print();
    }

    private void operationR() {
        this.isReversed = !isReversed;
    }

    private void operationD() {
        if (deque.isEmpty()) {
            throw new IllegalStateException();
        }

        if (isReversed) {
            deque.pollLast();
        } else {
            deque.pollFirst();
        }
    }

    private String print() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");

        if (isReversed) {
            if (!deque.isEmpty()) {
                buffer.append(deque.pollLast());
            }

            while (!deque.isEmpty()) {
                buffer.append(",");
                buffer.append(deque.pollLast());
            }
        } else {
            if (!deque.isEmpty()) {
                buffer.append(deque.pollFirst());
            }

            while (!deque.isEmpty()) {
                buffer.append(",");
                buffer.append(deque.pollFirst());
            }
        }

        buffer.append("]");
        return buffer.toString();
    }
}