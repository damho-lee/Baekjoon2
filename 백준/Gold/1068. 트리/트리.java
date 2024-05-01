import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] tree;
    private static int deleteVertex;
    private static int answer = 0;
    private static int root;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine().trim());
            tree = new ArrayList[size];
            int[] vertex = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < size; i++) {
                tree[i] = new ArrayList<>();
            }
            for (int i = 0; i < size; i++) {
                if (vertex[i] == -1) {
                    root = i;
                } else {
                    tree[vertex[i]].add(i);
                }
            }
            deleteVertex = Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calculate() {
        dfs(root);
    }

    private static void dfs(int vertex) {
        if (vertex == deleteVertex) {
            return;
        }
        if (tree[vertex].isEmpty() || tree[vertex].size() == 1 && tree[vertex].get(0) == deleteVertex) {
            answer++;
            return;
        }

        for (Integer child : tree[vertex]) {
            dfs(child);
        }
    }

    public static void main(String[] args) {
        readInput();
        calculate();
        System.out.println(answer);
    }
}
