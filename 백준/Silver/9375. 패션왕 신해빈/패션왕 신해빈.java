import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < n; i++) {
                writer.write(Solution.solve(reader) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

class Solution {
    public static int solve(BufferedReader reader) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        int result = 1;

        int n = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");

            map.compute(inputs[1], (key, value) -> value == null ? 1 : value + 1);
        }

        for (Integer value : map.values()) {
            result *= (value + 1);
        }

        return result - 1;
    }
}