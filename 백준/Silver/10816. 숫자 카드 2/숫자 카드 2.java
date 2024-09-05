import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            Map<Integer, Integer> map = new HashMap<>();
            String[] inputs = reader.readLine().split(" ");
            if (inputs.length != n) {
                throw new RuntimeException("n과 입력된 카드의 개수가 다릅니다.");
            }

            for (int i = 0; i < n; i++) {
                int card = Integer.parseInt(inputs[i]);
                map.merge(card, 1, Integer::sum);
            }

            int m = Integer.parseInt(reader.readLine().trim());
            inputs = reader.readLine().split(" ");
            if (inputs.length != m) {
                throw new RuntimeException("m과 입력된 카드의 개수가 다릅니다.");
            }

            for (int i = 0; i < m; i++) {
                int card = Integer.parseInt(inputs[i]);
                writer.write(map.getOrDefault(card, 0) + " ");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isValidInput(int n, int m) {
        return n >= 1 && n <= 100000 && m >= 1 && m <= 100000;
    }
}