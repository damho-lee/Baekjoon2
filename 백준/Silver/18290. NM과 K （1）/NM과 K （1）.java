import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int k = Integer.parseInt(inputs[2]);
            int[][] array = new int[n][m];

            for (int i = 0; i < n; i++) {
                array[i] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            solution = new Solution(k, array);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private static int[] deltaX = {-1, 1, 0, 0};
    private static int[] deltaY = {0, 0, -1, 1};
    private final int k;
    private final int[][] array;
    private boolean[][] visited;
    private int max;

    public Solution(int k, int[][] array) {
        this.k = k;
        this.array = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                this.array[i][j] = array[i][j];
            }
        }

        init();
    }

    private void init() {
        this.visited = new boolean[array.length][array[0].length];
        this.max = Integer.MIN_VALUE;
    }

    public int solve() {
        init();

        dfs(0, 0, 0, 0);

        return this.max;
    }

    private void dfs(int x, int y, int sum, int count) {
        if (count == k) {
            this.max = Math.max(max, sum);
            return;
        }

        for (int i = x; i < array.length; i++) {
            for (int j = y; j < array[i].length; j++) {
                if (!visited[i][j] && isAvailable(i, j)) {
                    visited[i][j] = true;
                    dfs(x, y, sum + array[i][j], count + 1);
                    visited[i][j] = false;
                }
            }
        }
    }

    private boolean isAvailable(int x, int y) {
        int newX;
        int newY;

        for (int i = 0; i < deltaX.length; i++) {
            newX = x + deltaX[i];
            newY = y + deltaY[i];

            if (isValid(newX, newY) && visited[newX][newY]) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < array.length && y >= 0 && y < array[x].length;
    }
}