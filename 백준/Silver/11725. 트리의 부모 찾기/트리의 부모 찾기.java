import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    private static List<Integer>[] readInput() {
        List<Integer>[] graph;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfVertex = Integer.parseInt(reader.readLine());
            graph = new List[numberOfVertex + 1];

            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < graph.length - 2; i++) {
                String[] inputs = reader.readLine().trim().split(" ");
                int vertex1 = Integer.parseInt(inputs[0]);
                int vertex2 = Integer.parseInt(inputs[1]);
                graph[vertex1].add(vertex2);
                graph[vertex2].add(vertex1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return graph;
    }

    private static void run(List<Integer>[] graph) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        int root = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        visited[root] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int child : graph[current]) {
                if (!visited[child]) {
                    array[child] = current;
                    stack.push(child);
                    visited[child] = true;
                }
            }
        }

        for (int i = 2; i < array.length; i++) {
            writer.write(array[i] + "\n");
        }
        writer.flush();
    }

    public static void main(String[] args) {
        List<Integer>[] graph = readInput();
        try {
            run(graph);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
