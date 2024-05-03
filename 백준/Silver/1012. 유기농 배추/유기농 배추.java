import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final int[] dx = new int[]{-1, 0, 0, 1};
    private static final int[] dy = new int[]{0, 1, -1, 0};
    private static boolean[][] graph;

    private static void readInput(BufferedReader reader) {
        try {
            String[] inputs = reader.readLine().trim().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int column = Integer.parseInt(inputs[1]);
            int size = Integer.parseInt(inputs[2]);

            graph = new boolean[row][column];
            for (int i = 0; i < size; i++) {
                inputs = reader.readLine().trim().split(" ");
                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);
                graph[x][y] = true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(x, y));

        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];
                if (isValid(newX, newY) && graph[newX][newY] && !visited[newX][newY]) {
                    stack.push(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[x].length;
    }

    private static void run() {
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < number; i++) {
                readInput(reader);
                stringBuffer.append(calculate() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        run();
    }
}

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
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