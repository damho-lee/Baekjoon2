import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            solution = new Solution(reader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solution());
    }
}

class Solution {
    private int[] parent;
    private PriorityQueue<Edge> edges;

    public Solution(BufferedReader reader) throws IOException {
        String[] inputs = reader.readLine().split(" ");
        int numberOfVertex = Integer.parseInt(inputs[0]);
        int numberOfEdge = Integer.parseInt(inputs[1]);

        parent = new int[numberOfVertex + 1];
        Arrays.fill(parent, -1);
        edges = new PriorityQueue<>();

        for (int i = 0; i < numberOfEdge; i++) {
            inputs = reader.readLine().split(" ");
            int vertex1 = Integer.parseInt(inputs[0]);
            int vertex2 = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);

            edges.offer(new Edge(vertex1, vertex2, weight));
        }
    }

    public int solution() {
        int weight = 0;
        int numberOfSelectedEdge = 0;

        while (!edges.isEmpty()) {
            Edge edge = edges.poll();

            int vertex1 = edge.getVertex1();
            int vertex2 = edge.getVertex2();

            if (findParent(vertex1) != findParent(vertex2)) {
                union(vertex1, vertex2);
                weight += edge.getWeight();
                numberOfSelectedEdge++;

                if (numberOfSelectedEdge >= parent.length - 2) {
                    break;
                }
            }
        }

        return weight;
    }

    private int findParent(int child) {
        int target = child;

        while (parent[target] != -1) {
            target = parent[target];
        }

        return target;
    }

    private void union(int child1, int child2) {
        int parent1 = findParent(child1);
        int parent2 = findParent(child2);

        parent[parent2] = parent1;
    }
}

class Edge implements Comparable {
    private int vertex1;
    private int vertex2;
    private int weight;

    public Edge(int vertex1, int vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public int getVertex1() {
        return vertex1;
    }

    public int getVertex2() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge other = (Edge) o;

        return this.getWeight() - other.getWeight();
    }
}