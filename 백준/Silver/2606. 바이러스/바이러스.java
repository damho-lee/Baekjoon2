import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int count = 0;
    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfVertex = Integer.parseInt(reader.readLine().trim());
            int numberOfEdge = Integer.parseInt(reader.readLine().trim());
            graph = new ArrayList[numberOfVertex + 1];
            visited = new boolean[graph.length];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < numberOfEdge; i++) {
                String[] inputs = reader.readLine().trim().split(" ");
                int vertex1 = Integer.parseInt(inputs[0].trim());
                int vertex2 = Integer.parseInt(inputs[1].trim());
                graph[vertex1].add(vertex2);
                graph[vertex2].add(vertex1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;

        for (Integer child : graph[vertex]) {
            if (!visited[child]) {
                dfs(child);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        readInput();
        dfs(1);
        System.out.println(count);
    }
}
