import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<List<Pair>> graph;
    private static boolean[] visited;

    private static int max;
    private static int farthestVertex;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine().trim());
            graph = new ArrayList<>();
            for (int i = 0; i < size + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < size - 1; i++) {
                String[] inputs = reader.readLine().trim().split(" ");
                int parent = Integer.parseInt(inputs[0]);
                int child = Integer.parseInt(inputs[1]);
                int weight = Integer.parseInt(inputs[2]);
                graph.get(child).add(new Pair(parent, weight));
                graph.get(parent).add(new Pair(child, weight));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        visited = new boolean[graph.size()];
        dfs(1, 0);
        visited = new boolean[graph.size()];
        dfs(farthestVertex, 0);
    }

    private static void dfs(int vertex, int count) {
        visited[vertex] = true;
        if (max < count) {
            max = count;
            farthestVertex = vertex;
        }

        for (Pair pair : graph.get(vertex)) {
            if (!visited[pair.getTargetVertex()]) {
                dfs(pair.getTargetVertex(), count + pair.getWeight());
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
    private int weight;

    public Pair(int targetVertex, int weight) {
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public int getTargetVertex() {
        return targetVertex;
    }

    public int getWeight() {
        return weight;
    }
}