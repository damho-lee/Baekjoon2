import java.io.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {
    private static Set<String> unheard;
    private static Set<String> result;

    private static void init() {
        unheard = new TreeSet<>();
        result = new TreeSet<>();
    }

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < inputs[0]; i++) {
                unheard.add(reader.readLine().trim());
            }
            for (int i = 0; i < inputs[1]; i++) {
                String input = reader.readLine().trim();
                if (unheard.contains(input)) {
                    result.add(input);
                    unheard.remove(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print() {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            writer.write(result.size() + "\n");
            
            for (String target : result) {
                writer.write(target);
                writer.write("\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void run() {
        init();
        readInput();
        print();
    }

    public static void main(String[] args) {
        run();
    }
}
