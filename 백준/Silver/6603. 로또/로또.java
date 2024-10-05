import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            while (true) {
                int[] numbers = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                if (numbers[0] == 0) {
                    break;
                }

                Solution solution = new Solution(Arrays.copyOfRange(numbers, 1, numbers.length));
                writer.write(solution.solve());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

class Solution {
    private int[] numbers;
    private boolean[] visited;
    private final StringBuffer stringBuffer;

    public Solution(int[] numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length];
        stringBuffer = new StringBuffer();
    }

    public String solve() {
        dfs(0, 0);

        return this.stringBuffer.toString();
    }

    private void dfs(int startIndex, int depth) {
        if (depth == 6) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    stringBuffer.append(numbers[i] + " ");
                }
            }

            stringBuffer.append("\n");
            return;
        }

        for (int i = startIndex; i < numbers.length; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}