import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] graph = new int[n][];
            for (int i = 0; i < n; i++) {
                graph[i] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            solution = new Solution(graph);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solution());

    }

}

class Solution {
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int DIAGONAL = 2;
    private int[][] graph;
    private int result;

    public Solution(int[][] graph) {
        this.graph = graph;
        result = 0;
    }

    public int solution() {
        dfs(0, 1, 0);

        return this.result;
    }

    public void dfs(int x, int y, int direction) {
        if (x == graph.length - 1 && y == graph[x].length - 1) {
            increment();
            return;
        }

        switch (direction) {
            case RIGHT:
                if (isValid(x, y + 1) && isBlank(x, y + 1)) {
                    dfs(x, y + 1, RIGHT);
                }
                break;
            case DOWN:
                if (isValid(x + 1, y) && isBlank(x + 1, y)) {
                    dfs(x + 1, y, DOWN);
                }
                break;
            case DIAGONAL:
                if (isValid(x, y + 1) && isBlank(x, y + 1)) {
                    dfs(x, y + 1, RIGHT);
                }

                if (isValid(x + 1, y) && isBlank(x + 1, y)) {
                    dfs(x + 1, y, DOWN);
                }
                break;
            default:
                throw new IllegalArgumentException("방향이 말안됨");
        }

        if (isValid(x + 1, y + 1) && isBlank(x + 1, y) && isBlank(x, y + 1) && isBlank(x + 1, y + 1)) {
            dfs(x + 1, y + 1, DIAGONAL);
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[x].length;
    }

    private boolean isBlank(int x, int y) {
        return graph[x][y] == 0;
    }

    private synchronized void increment() {
        result++;
    }
}