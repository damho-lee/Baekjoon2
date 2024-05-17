import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] floor;
    private static int start;
    private static int destination;
    private static int up;
    private static int down;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            floor = new int[Integer.parseInt(inputs[0]) + 1];
            start = Integer.parseInt(inputs[1]);
            destination = Integer.parseInt(inputs[2]);
            up = Integer.parseInt(inputs[3]);
            down = Integer.parseInt(inputs[4]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        Queue<Integer> queue = new LinkedList<>();
        floor[start] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                System.out.println(floor[current] - 1);
                return;
            }

            if (isValid(current + up) && floor[current + up] == 0) {
                floor[current + up] = floor[current] + 1;
                queue.add(current + up);
            }

            if (isValid(current - down) && floor[current - down] == 0) {
                floor[current - down] = floor[current] + 1;
                queue.add(current - down);
            }
        }

        System.out.println("use the stairs");
    }

    private static boolean isValid(int x) {
        return x > 0 && x < floor.length;
    }

    public static void main(String[] args) {
        readInput();
        run();
    }
}
