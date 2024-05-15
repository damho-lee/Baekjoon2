import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] graph;
    private static int from;
    private static int to;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            from = Integer.parseInt(inputs[0]);
            to = Integer.parseInt(inputs[1]);
            graph = new int[100001];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        boolean[] visited = new boolean[graph.length];
        graph[from] = 1;
        visited[from] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == to) {
                break;
            }

            if (current - 1 >= 0 && current - 1 < graph.length && !visited[current - 1]) {
                graph[current - 1] = graph[current] + 1;
                visited[current - 1] = true;
                queue.add(current - 1);
            }

            if (current + 1 >= 0 && current + 1 < graph.length && !visited[current + 1]) {
                graph[current + 1] = graph[current] + 1;
                visited[current + 1] = true;
                queue.add(current + 1);
            }

            if (current * 2 >= 0 && current * 2 < graph.length && !visited[current * 2]) {
                graph[current * 2] = graph[current] + 1;
                visited[current * 2] = true;
                queue.add(current * 2);
            }
        }

        System.out.println(graph[to] - 1);
    }

    public static void main(String[] args) {
        readInput();
        run();
    }
}
