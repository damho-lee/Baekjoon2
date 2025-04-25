import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            String word;
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                word = reader.readLine().trim();

                if (word.length() < m) {
                    continue;
                }

                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            List<String> keyList = new ArrayList<>(map.keySet());
            keyList.sort((s1, s2) -> {
                int diff = map.get(s2) - map.get(s1);
                if (diff != 0) {
                    return diff;
                }

                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                }

                return s1.compareTo(s2);
            });

            for (String s : keyList) {
                writer.write(s + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}