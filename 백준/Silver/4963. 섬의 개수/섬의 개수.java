import java.io.*;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    private static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    private static int[][] graph;

    private static void readInput(BufferedReader reader) throws IOException {
        for (int i = 0; i < graph.length; i++) {
            String[] inputs = reader.readLine().trim().split(" ");
            graph[i] = Stream.of(inputs).mapToInt(Integer::parseInt).toArray();
        }
    }

    private static int calculate() {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(x, y));

        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();

            for (int i = 0; i < dx.length; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];

                if (isValid(newX, newY) && graph[newX][newY] == 1 && !visited[newX][newY]) {
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
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String[] inputs = reader.readLine().trim().split(" ");
                int row = Integer.parseInt(inputs[0]);
                int column = Integer.parseInt(inputs[1]);

                if (row == 0 && column == 0) {
                    break;
                }

                graph = new int[column][row];
                readInput(reader);
                writer.write(calculate() + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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