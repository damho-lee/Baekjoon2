import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int count = 1;
    private static void run() {
        List<List<Integer>> graph = new ArrayList<>();
        int startVertex = 0;
        int[] visited;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(inputs[0].trim());
            int m = Integer.parseInt(inputs[1].trim());
            startVertex = Integer.parseInt(inputs[2].trim());
            visited = new int[n + 1];
            visited[0] = -1;
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                inputs = reader.readLine().trim().split(" ");
                int vertex1 = Integer.parseInt(inputs[0].trim());
                int vertex2 = Integer.parseInt(inputs[1].trim());
                graph.get(vertex1).add(vertex2);
                graph.get(vertex2).add(vertex1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort(Integer::compareTo);
        }

        dfs(graph, visited, startVertex);
        print(visited);
    }

    private static void dfs(List<List<Integer>> graph, int[] visited, int vertex) {
        visited[vertex] = count++;

        for (Integer childVertex : graph.get(vertex)) {
            if (visited[childVertex] == 0) {
                dfs(graph, visited, childVertex);
            }
        }
    }

    private static void print(int[] visited) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < visited.length; i++) {
            stringBuffer.append(visited[i]).append("\n");
        }
        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        run();
    }
}
