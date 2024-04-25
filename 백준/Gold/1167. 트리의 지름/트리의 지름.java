import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<List<Pair>> graph;
    private static boolean[] visited;
    private static int far = 0;
    private static int max = 0;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int v = Integer.parseInt(reader.readLine().trim());
            graph = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < v; i++) {
                String[] inputs = reader.readLine().trim().split(" ");
                int vertex = Integer.parseInt(inputs[0]);
                int j = 1;
                while (j < inputs.length - 2) {
                    int targetVertex = Integer.parseInt(inputs[j++]);
                    int distance = Integer.parseInt(inputs[j++]);
                    graph.get(vertex).add(new Pair(targetVertex, distance));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        visited = new boolean[graph.size()];
        dfs(1, 0);

        visited = new boolean[graph.size()];
        dfs(far, 0);
    }

    private static void dfs(int vertex, int dist) {
        visited[vertex] = true;
        if (max < dist) {
            max = dist;
            far = vertex;
        }

        for (Pair pair : graph.get(vertex)) {
            if (!visited[pair.getTargetVertex()]) {
                dfs(pair.getTargetVertex(), dist + pair.getDistance());
            }
        }
    }

    public static void main(String[] args) {
        readInput();
        run();
        System.out.println(max);
    }
}

class Pair {
    private int targetVertex;
    private int distance;

    public Pair(int targetVertex, int distance) {
        this.targetVertex = targetVertex;
        this.distance = distance;
    }

    public int getTargetVertex() {
        return targetVertex;
    }

    public int getDistance() {
        return distance;
    }
}