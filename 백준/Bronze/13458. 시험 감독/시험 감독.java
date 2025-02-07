import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfRoom = Integer.parseInt(reader.readLine().trim());
            int[] rooms = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long result = 0;
            String[] inputs = reader.readLine().split(" ");
            int b = Integer.parseInt(inputs[0]);
            int c = Integer.parseInt(inputs[1]);

            for (int room : rooms) {
                result += calculate(room, b, c);
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculate(int numberOfApplicants, int b, int c) {
        int count = 1;
        int n = numberOfApplicants - b;

        if (n > 0) {
            count += n % c == 0 ? n / c : n / c + 1;
        }

        return count;
    }
}