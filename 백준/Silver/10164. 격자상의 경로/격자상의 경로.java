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
                int x = target / m;
                int y = target % m - 1;
                circle = new Point(x, y);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        for (int i = 0; i < grid.length; i++) {
            grid[i][0] = 1;
        }

        for (int i = 0; i < grid[0].length; i++) {
            grid[0][i] = 1;
        }

        if (circle == null) {
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[i].length; j++) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }

            return grid[grid.length - 1][grid[0].length - 1];
        } else {
            for (int i = 1; i <= circle.getX(); i++) {
                for (int j = 1; j <= circle.getY(); j++) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }

            int result = grid[circle.getX()][circle.getY()];

            for (int i = circle.getX(); i < grid.length; i++) {
                grid[i][circle.getY()] = 1;
            }

            for (int i = circle.getY(); i < grid[0].length; i++) {
                grid[circle.getX()][i] = 1;
            }

            for (int i = circle.getX() + 1; i < grid.length; i++) {
                for (int j = circle.getY() + 1; j < grid[i].length; j++) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
            
            return result * grid[grid.length - 1][grid[0].length - 1];
        }
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}

class Point {
    private int x;
    private int y;

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