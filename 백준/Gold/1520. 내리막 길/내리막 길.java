import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] map;
    private static int[][] count;
    private static final int[] dx = new int[]{-1, 0, 0, 1};
    private static final int[] dy = new int[]{0, -1, 1, 0};
    private static int r;
    private static int c;
    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            r = Integer.parseInt(inputs[0]);
            c = Integer.parseInt(inputs[1]);
            map = new int[r][c];
            count = new int[r][c];

            for (int i = 0; i < r; i++) {
                inputs = reader.readLine().trim().split(" ");
                for (int j = 0; j < c; j++) {
                    map[i][j] = Integer.parseInt(inputs[j]);
                    count[i][j] = -1;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static int calculate() {
        return dfs(0, 0);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
    }

    private static boolean isDestination(int x, int y) {
        return r - 1 == x && c - 1 == y;
    }

    private static int dfs(int x, int y) {
        if (isDestination(x, y)) {
            return 1;
        }

        if (count[x][y] == -1) {
            count[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (isValid(newX, newY) && map[x][y] > map[newX][newY]) {
                    count[x][y] += dfs(newX, newY);
                }
            }
        }

        return count[x][y];
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());;
    }
}
