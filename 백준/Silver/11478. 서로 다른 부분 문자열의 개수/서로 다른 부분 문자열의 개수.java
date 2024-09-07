import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine().trim();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < input.length(); i++) {
                for (int j = i + 1; j < input.length() + 1; j++) {
                    set.add(input.substring(i, j));
                }
            }

            System.out.println(set.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}