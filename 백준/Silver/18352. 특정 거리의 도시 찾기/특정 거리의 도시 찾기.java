import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int k = Integer.parseInt(inputs[2]);
            int x = Integer.parseInt(inputs[3]);

            List<Integer>[] vertex = new List[n + 1];
            for (int i = 0; i < vertex.length; i++) {
                vertex[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                inputs = reader.readLine().split(" ");
                int v1 = Integer.parseInt(inputs[0]);
                int v2 = Integer.parseInt(inputs[1]);

                vertex[v1].add(v2);
            }

            solution = new Solution(vertex);
            System.out.println(solution.solve(k, x));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private final List<Integer>[] lists;
    private static final int INFINITE = Integer.MAX_VALUE;

    public Solution(List<Integer>[] lists) {
        this.lists = lists;
    }

    public String solve(int key, int start) {
        int[] distance = new int[this.lists.length + 1];
        Arrays.fill(distance, INFINITE);
        distance[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> resultSet = new TreeSet<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (distance[current] > key) {
                break;
            } else if (distance[current] == key) {
                resultSet.add(current);
            }

            for (Integer next : lists[current]) {
                if (distance[next] == INFINITE) {
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }

        return !resultSet.isEmpty() ?
                resultSet.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining("\n")) : "-1";
    }
}