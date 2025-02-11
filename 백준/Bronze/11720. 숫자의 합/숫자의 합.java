import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int result = Stream.of(reader.readLine().split("")).mapToInt(Integer::parseInt).sum();

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}