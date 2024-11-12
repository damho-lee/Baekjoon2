import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    private static List<Node>[] vertexes;
    private static int[] distance;
    private static int startVertex;

    public static void main(String[] args) {
        readInput();
        System.out.println(solve());
    }

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int numberOfVertex = Integer.parseInt(inputs[0]);
            int numberOfEdge = Integer.parseInt(inputs[1]);
            startVertex = Integer.parseInt(reader.readLine().trim());

            vertexes = new ArrayList[numberOfVertex + 1];
            distance = new int[numberOfVertex + 1];

            for (int i = 0; i < vertexes.length; i++) {
                vertexes[i] = new ArrayList<>();
                distance[i] = INF;
            }

            for (int i = 0; i < numberOfEdge; i++) {
                inputs = reader.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);
                int weight = Integer.parseInt(inputs[2]);

                vertexes[start].add(new Node(end, weight));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String solve() {
        boolean[] visited = new boolean[vertexes.length];
        distance[startVertex] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startVertex, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visited[current.getVertex()] = true;

            for (Node next : vertexes[current.getVertex()]) {
                if (!visited[next.getVertex()] &&
                        distance[next.getVertex()] > distance[current.getVertex()] + next.getWeight()) {
                    distance[next.getVertex()] = distance[current.getVertex()] + next.getWeight();
                    queue.add(new Node(next.getVertex(), distance[next.getVertex()]));
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        String string;
        for (int i = 1; i < distance.length; i++) {
            string = distance[i] == INF ? "INF" : String.valueOf(distance[i]);
            stringBuffer.append(string).append("\n");
        }

        return stringBuffer.toString();
    }
}

class Node implements Comparable {
    private final int vertex;
    private final int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        Node other = (Node) o;

        return this.getWeight() - other.getWeight();
    }
}