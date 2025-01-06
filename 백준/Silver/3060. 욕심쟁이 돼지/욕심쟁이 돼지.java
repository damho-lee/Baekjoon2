import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCase = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < testCase; i++) {
                int total = Integer.parseInt(reader.readLine().trim());
                int pigTotal = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
                int day = 1;

                while (total >= pigTotal) {
                    day++;
                    pigTotal *= 4;
                }

                writer.write(day + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}