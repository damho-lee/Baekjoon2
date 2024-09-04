import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            Map<String, String> mapForNumber = new HashMap<>();
            Map<String, String> mapForName = new HashMap<>();
            String name;
            String number;

            for (int i = 0; i < n; i++) {
                name = reader.readLine().trim();
                number = String.valueOf(i + 1);
                mapForNumber.put(name, number);
                mapForName.put(number, name);
            }

            String input;
            for (int i = 0; i < m; i++) {
                input = reader.readLine().trim();
                if (mapForNumber.containsKey(input)) {
                    writer.write(mapForNumber.get(input));
                } else {
                    writer.write(mapForName.get(input));
                }
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}