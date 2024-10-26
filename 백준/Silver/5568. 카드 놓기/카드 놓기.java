import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int k = Integer.parseInt(reader.readLine().trim());
            int[] inputs = new int[n];
            for (int i = 0; i < n; i++) {
                inputs[i] = Integer.parseInt(reader.readLine().trim());
            }

            solution = new Solution(inputs, k);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private final int[] inputs;
    private final int length;
    private Set<String> set;
    private int[] array;
    private boolean[] visited;

    public Solution(int[] inputs, int length) {
        this.inputs = inputs.clone();
        this.length = length;
        init();
    }

    private void init() {
        this.set = new HashSet<>();
        this.array = new int[length];
        this.visited = new boolean[inputs.length];
    }

    public int solve() {
        init();

        dfs(0);

        return set.size();
    }

    private void dfs(int currentIndex) {
        if (currentIndex == array.length) {
            set.add(Arrays.stream(array)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining()));

            return;
        }

        for (int i = 0; i < inputs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[currentIndex] = inputs[i];
                dfs(currentIndex + 1);
                visited[i] = false;
            }
        }
    }
}