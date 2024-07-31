import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[] seats;
    private static List<Integer> vips;
    private static int n;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            vips = new ArrayList<>();
            n = Integer.parseInt(reader.readLine().trim());
            seats = new int[41];

            int m = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < m; i++) {
                vips.add(Integer.parseInt(reader.readLine().trim()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        seats[0] = 1;
        seats[1] = 1;
        for (int i = 2; i < seats.length; i++) {
            seats[i] = seats[i - 2] + seats[i - 1];
        }

        int previous = 0;
        int result = 1;

        for (Integer i : vips) {
            result *= seats[i - previous - 1];
            previous = i;
        }

        result *= seats[n - previous];

        return result;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
