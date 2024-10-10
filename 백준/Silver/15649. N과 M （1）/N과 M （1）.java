import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            Solution solution = new Solution(n, m);
            System.out.println(solution.solve());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

final class Solution {
    private final int n;
    private final int depth;
    private final StringBuffer stringBuffer;
    private boolean[] visited;
    private int[] array;

    public Solution(int n, int depth) {
        this.n = n;
        this.depth = depth;
        this.stringBuffer = new StringBuffer();
        this.visited = new boolean[n + 1];
        this.array = new int[depth];
    }

    public String solve() {
        stringBuffer.setLength(0);

        dfs(0);

        return this.stringBuffer.toString();
    }

    private void dfs(int currentIndex) {
        if (currentIndex == this.depth) {
            for (int i : array) {
                stringBuffer.append(i + " ");
            }

            stringBuffer.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[currentIndex] = i;
                dfs(currentIndex + 1);
                visited[i] = false;
            }
        }
    }
}