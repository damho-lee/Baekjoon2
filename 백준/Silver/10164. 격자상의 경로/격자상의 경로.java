import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] grid;
    private static Point circle;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");

            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int target = Integer.parseInt(inputs[2]);

            grid = new int[n][m];

            if (target != 0) {
                int x = (target - 1) / m;
                int y = (target - 1) % m;
                circle = new Point(x, y);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculatePaths(int startX, int startY, int endX, int endY) {
        int[][] dp = new int[endX - startX + 1][endY - startY + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= endX - startX; i++) {
            for (int j = 0; j <= endY - startY; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[endX - startX][endY - startY];
    }

    private static int calculate() {
        if (circle == null) {
            return calculatePaths(0, 0, grid.length - 1, grid[0].length - 1);
        } else {
            int part1 = calculatePaths(0, 0, circle.getX(), circle.getY());
            int part2 = calculatePaths(circle.getX(), circle.getY(), grid.length - 1, grid[0].length - 1);
            return part1 * part2;
        }
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}