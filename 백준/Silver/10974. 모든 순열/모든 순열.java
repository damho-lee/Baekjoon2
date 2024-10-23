import java.io.*;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            solution = new Solution(n);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private final int n;
    private StringBuffer stringBuffer;
    private boolean[] visited;
    private int[] array;

    public Solution(int n) {
        this.n = n;
        this.stringBuffer = new StringBuffer();
    }

    private void init() {
        this.stringBuffer.setLength(0);
        this.visited = new boolean[n + 1];
        this.array = new int[n];
    }

    public String solve() {
        init();

        dfs(0);

        return this.stringBuffer.toString();
    }

    private void dfs(int currentIndex) {
        if (currentIndex == this.n) {
            for (int i = 0; i < array.length; i++) {
                stringBuffer.append(array[i]).append(" ");
            }

            stringBuffer.append("\n");
        }

        for (int i = 1; i < this.n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[currentIndex] = i;
                dfs(currentIndex + 1);
                visited[i] = false;
            }
        }
    }
}