import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int column = Integer.parseInt(inputs[1]);
            int[][] graph = new int[row][column];

            for (int i = 0; i < row; i++) {
                graph[i] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            Solution solution = new Solution(graph);
            int x1;
            int y1;
            int x2;
            int y2;

            int numberOfCase = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < numberOfCase; i++) {
                inputs = reader.readLine().split(" ");
                x1 = Integer.parseInt(inputs[0]);
                y1 = Integer.parseInt(inputs[1]);
                x2 = Integer.parseInt(inputs[2]);
                y2 = Integer.parseInt(inputs[3]);
                writer.write(solution.calculate(x1, y1, x2, y2) + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private int[][] graph;
    private int[][] sumOfGraph;

    public Solution(int[][] graph) {
        if (graph == null || graph[0] == null) {
            throw new IllegalArgumentException("graph is empty");
        }

        this.graph = copyArray(graph);
        init();
    }

    public int calculate(int x1, int y1, int x2, int y2) {
        if (x1 > x2) {
            throw new IllegalArgumentException("x2 must be bigger than x1\t input : " + x1 + " " + x2);
        }

        if (y1 > y2) {
            throw new IllegalArgumentException("y2 must be bigger than y1\t input : " + y1 + " " + y2);
        }

        return sumOfGraph[x2][y2] - sumOfGraph[x2][y1 - 1] - sumOfGraph[x1 - 1][y2] + sumOfGraph[x1 - 1][y1 - 1];
    }

    private void init() {
        this.sumOfGraph = new int[graph.length + 1][graph[0].length + 1];
        sumOfGraph[1][1] = graph[0][0];

        for (int i = 2; i < sumOfGraph.length; i++) {
            sumOfGraph[i][1] = sumOfGraph[i - 1][1] + graph[i - 1][0];
        }

        for (int i = 2; i < sumOfGraph[0].length; i++) {
            sumOfGraph[1][i] = sumOfGraph[1][i - 1] + graph[0][i - 1];
        }

        for (int i = 2; i < sumOfGraph.length; i++) {
            for (int j = 2; j < sumOfGraph[i].length; j++) {
                sumOfGraph[i][j] = sumOfGraph[i - 1][j] + sumOfGraph[i][j - 1] - sumOfGraph[i - 1][j - 1] + graph[i - 1][j - 1];
            }
        }
    }

    private static int[][] copyArray(int[][] graph) {
        int[][] newGraph = new int[graph.length][];

        for (int i = 0; i < graph.length; i++) {
            newGraph[i] = Arrays.copyOf(graph[i], graph[i].length);
        }

        return newGraph;
    }
}