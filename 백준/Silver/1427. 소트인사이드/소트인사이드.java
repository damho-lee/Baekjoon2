import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String input = reader.readLine().trim();

            char[] array = input.toCharArray();
            Arrays.sort(array);
            for (int i = array.length - 1; i >= 0; i--) {
                writer.write(array[i]);
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
