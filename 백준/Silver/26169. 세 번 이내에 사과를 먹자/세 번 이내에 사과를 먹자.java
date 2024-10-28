import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    private static final int ARRAY_SIZE = 5;

    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[][] array = new int[ARRAY_SIZE][ARRAY_SIZE];

            for (int i = 0; i < ARRAY_SIZE; i++) {
                array[i] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            String[] inputs = reader.readLine().split(" ");
            Point start = new Point(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));

            solution = new Solution(array, start);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private final int[][] array;
    private final Point start;
    private boolean[][] visited;
    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};

    public Solution(int[][] array, Point start) {
        this.array = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = Arrays.copyOf(array[i], array[i].length);
        }

        this.start = Point.copy(start);
        this.visited = new boolean[this.array.length][this.array[0].length];
    }

    public int solve() {
        return dfs(this.start.getX(), this.start.getY(), 0, 0) ? 1 : 0;
    }

    private boolean dfs(int x, int y, int depth, int apple) {
        if (array[x][y] == 1) {
            apple++;
        }

        if (apple >= 2) {
            return true;
        }

        if (depth == 3) {
            return false;
        }

        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isValid(newX, newY) && !visited[newX][newY] && array[newX][newY] != -1) {
                if (dfs(newX, newY, depth + 1, apple)) {
                    return true;
                }
            }
        }
        visited[x][y] = false;

        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < array.length && y >= 0 && y < array[x].length;
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

    public static Point copy(Point point) {
        return new Point(point.getX(), point.getY());
    }
}