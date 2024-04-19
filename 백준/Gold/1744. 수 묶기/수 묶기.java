import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static PriorityQueue<Integer> positiveNumbers = new PriorityQueue<>(Comparator.reverseOrder());
    private static PriorityQueue<Integer> negativeNumbers = new PriorityQueue<>(Comparator.comparingInt(x -> x));
    private static List<Integer> zeros = new ArrayList<>();

    public static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {
                int number = Integer.parseInt(reader.readLine());
                if (number < 0) {
                    negativeNumbers.add(number);
                } else if (number > 0) {
                    positiveNumbers.add(number);
                } else {
                    zeros.add(number);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long calculate() {
        long sum = 0;

        while (positiveNumbers.size() > 1) {
            int x = positiveNumbers.poll();
            int y = positiveNumbers.poll();
            if (x + y > x * y) {
                sum += x + y;
            } else {
                sum += x * y;
            }
        }
        if (!positiveNumbers.isEmpty()) {
            sum += positiveNumbers.poll();
        }

        while (negativeNumbers.size() > 1) {
            int x = negativeNumbers.poll();
            int y = negativeNumbers.poll();
            sum += x * y;
        }
        if (!negativeNumbers.isEmpty()) {
            if (zeros.isEmpty()) {
                sum += negativeNumbers.poll();
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
