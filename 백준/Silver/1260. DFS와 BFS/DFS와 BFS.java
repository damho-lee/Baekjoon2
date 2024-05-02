import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] graph;
    private static int startVertex;
    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int numberOfVertex = Integer.parseInt(inputs[0]);
            int numberOfEdge = Integer.parseInt(inputs[1]);
            startVertex = Integer.parseInt(inputs[2]);

            graph = new ArrayList[numberOfVertex + 1];
            for (int i = 0; i < numberOfVertex + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < numberOfEdge; i++) {
                inputs = reader.readLine().trim().split(" ");
                int vertex1 = Integer.parseInt(inputs[0]);
                int vertex2 = Integer.parseInt(inputs[1]);
                graph[vertex1].add(vertex2);
                graph[vertex2].add(vertex1);
            }
            for (int i = 0; i < numberOfVertex + 1; i++) {
                graph[i].sort(Integer::compareTo);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(int vertex) {
        Stack<Integer> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        boolean[] visited = new boolean[graph.length];
        dfsRecursion(vertex, visited, stringBuffer);

        System.out.println(stringBuffer);
    }

    private static void dfsRecursion(int vertex, boolean[] visited, StringBuffer stringBuffer) {
        visited[vertex] = true;
        stringBuffer.append(vertex).append(" ");

        for (Integer child : graph[vertex]) {
            if (!visited[child]) {
                dfsRecursion(child, visited, stringBuffer);
            }
        }
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();
        boolean[] visited = new boolean[graph.length];
        queue.add(vertex);
        visited[vertex] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            stringBuffer.append(current).append(" ");
            for (Integer child : graph[current]) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                }
            }
        }
        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        readInput();
        dfs(startVertex);
        bfs(startVertex);
    }
}
