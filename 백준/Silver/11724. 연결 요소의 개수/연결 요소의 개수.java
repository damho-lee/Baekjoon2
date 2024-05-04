import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    private static List<Integer>[] readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int numberOfVertex = Integer.parseInt(inputs[0]);
            int numberOfEdge = Integer.parseInt(inputs[1]);

            List<Integer>[] graph = new List[numberOfVertex + 1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < numberOfEdge; i++) {
                inputs = reader.readLine().trim().split(" ");
                int vertex1 = Integer.parseInt(inputs[0]);
                int vertex2 = Integer.parseInt(inputs[1]);

                graph[vertex1].add(vertex2);
                graph[vertex2].add(vertex1);
            }

            return graph;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(List<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        int count = 0;

        for (int i = 1; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }

        return count;
    }

    private static void dfs(List<Integer>[] graph, boolean[] visited, int vertex) {
        visited[vertex] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (Integer child : graph[current]) {
                if (!visited[child]) {
                    visited[child] = true;
                    stack.push(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer>[] graph = readInput();
        System.out.println(calculate(graph));
    }
}
