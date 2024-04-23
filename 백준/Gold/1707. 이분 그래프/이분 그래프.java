import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int k = Integer.parseInt(reader.readLine().trim());
            List<List<Integer>> graph;
            int[] colors;
            for (int i = 0; i < k; i++) {
                String[] inputs = reader.readLine().trim().split(" ");
                int v = Integer.parseInt(inputs[0]);
                int e = Integer.parseInt(inputs[1]);

                graph = new ArrayList<>();
                for (int j = 0; j <= v; j++) {
                    graph.add(new ArrayList<>());
                }
                colors = new int[v + 1];

                for (int j = 0; j < e; j++) {
                    inputs = reader.readLine().trim().split(" ");
                    int first = Integer.parseInt(inputs[0]);
                    int second = Integer.parseInt(inputs[1]);
                    graph.get(first).add(second);
                    graph.get(second).add(first);
                }

                boolean result = true;
                for (int j = 0; j <= v; j++) {
                    if (colors[j] == 0) {
                        result = isBipartiteGraph(graph, colors, j);
                    }
                    if (!result) {
                        break;
                    }
                }
                if (result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isBipartiteGraph(List<List<Integer>> graph, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int next : graph.get(vertex)) {
                if (colors[vertex] == colors[next]) {
                    return false;
                }

                if (colors[next] == 0) {
                    colors[next] = colors[vertex] * -1;
                    queue.add(next);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        run();
    }
}
