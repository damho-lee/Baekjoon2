import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    private static void run() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int input = 0;
            int output = 0;

            for (int i = 0; i < n; i++) {
                input = Integer.parseInt(reader.readLine().trim());

                if (input == 0) {
                    if (queue.isEmpty()) {
                        output = 0;
                    } else {
                        output = queue.poll();
                    }
                    stringBuffer.append(output);
                    stringBuffer.append("\n");
                } else {
                    queue.add(input);
                }
            }

            System.out.println(stringBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        run();
    }
}
