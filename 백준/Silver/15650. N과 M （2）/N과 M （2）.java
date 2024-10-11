import java.io.*;

public class Main {
    public static void main(String[] args) {
        Solution solution;
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            solution = new Solution(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private boolean[] visited;
    private final int length;
    private StringBuffer stringBuffer;

    public Solution(int n, int m) {
        this.visited = new boolean[n + 1];
        this.length = m;
        this.stringBuffer = new StringBuffer();
    }

    public String solve() {
        this.stringBuffer.setLength(0);

        dfs(1, 0);

        return this.stringBuffer.toString();
    }

    private void dfs(int startIndex, int length) {
        if (length == this.length) {
            int count = 0;
            for (int i = 1; i < visited.length && count < length; i++) {
                if (visited[i]) {
                    stringBuffer.append(i).append(" ");
                    count++;
                }
            }
            stringBuffer.append("\n");
        }

        for (int i = startIndex; i < visited.length; i++) {
            visited[i] = true;
            dfs(i + 1, length + 1);
            visited[i] = false;
        }
    }
}