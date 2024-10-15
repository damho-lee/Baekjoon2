import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int[] array = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            solution = new Solution(m, array);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private final int lengthOfSequence;
    private final int[] array;
    private boolean[] visited;
    private StringBuffer stringBuffer;

    public Solution(int lengthOfSequence, int[] array) {
        this.lengthOfSequence = lengthOfSequence;

        int[] tmp = array.clone();
        Arrays.sort(tmp);
        this.array = tmp;

        this.visited = new boolean[array.length];
        this.stringBuffer = new StringBuffer();
    }

    public String solve() {
        this.stringBuffer.setLength(0);

        dfs(0, 0);

        return this.stringBuffer.toString();
    }

    private void dfs(int currentIndex, int length) {
        if (length == this.lengthOfSequence) {
            int count = 0;
            for (int i = 0; i < visited.length && count < lengthOfSequence; i++) {
                if (visited[i]) {
                    stringBuffer.append(array[i]).append(" ");
                    count++;
                }
            }

            stringBuffer.append("\n");
            return;
        }

        for (int i = currentIndex; i < array.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, length + 1);
                visited[i] = false;
            }
        }
    }
}