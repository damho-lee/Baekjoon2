import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            HashMap<Integer, Integer> map = new HashMap<>();
            String[] inputs = reader.readLine().split(" ");
            int order = 0;
            int[] origin = new int[n];
            int[] sortedArray = new int[n];

            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(inputs[i]);
                origin[i] = input;
                sortedArray[i] = input;
            }

            Arrays.sort(sortedArray);

            for (int i = 0; i < sortedArray.length; i++) {
                if (!map.containsKey(sortedArray[i])) {
                    map.put(sortedArray[i], order++);
                }
            }

            for (int i : origin) {
                writer.write(map.get(i) + " ");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}