import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static final int QUEUE_NUMBER = 0;
    private static final int STACK_NUMBER = 1;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Deque<Integer> deque = new ArrayDeque<>();
            int numberOfDataStructure = Integer.parseInt(reader.readLine().trim());
            int[] dataStructureType = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] initValue = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int lengthOfSequence = Integer.parseInt(reader.readLine().trim());
            int[] sequence = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < initValue.length; i++) {
                if (dataStructureType[i] == QUEUE_NUMBER) {
                    deque.addLast(initValue[i]);
                }
            }

            for (int sequenceNumber : sequence) {
                deque.addFirst(sequenceNumber);
                writer.write(deque.pollLast() + " ");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}