import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    private static int[][] graph;
    private static int[] dx = new int[]{-1, 0, 0, 1};
    private static int[] dy = new int[]{0, -1, 1, 0};

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph = new int[inputs[1]][inputs[0]];
            int n = inputs[2];

            for (int i = 0; i < n; i++) {
                inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x1 = inputs[0];
                int y1 = inputs[1];
                int x2 = inputs[2];
                int y2 = inputs[3];
                for (int j = x1; j < x2; j++) {
                    for (int k = y1; k < y2; k++) {
                        graph[j][k] = 1;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (!visited[i][j] && graph[i][j] == 0) {
                    list.add(dfs(i, j, visited));
                    count++;
                }
            }
        }

        list.sort(Integer::compareTo);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            writer.write(count + "\n");
            for (int integer : list) {
                writer.write(integer + " ");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(x, y));
        int count = 1;

        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];
                if (isValid(newX, newY) && graph[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    stack.push(new Coordinate(newX, newY));
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[x].length;
    }

    public static void main(String[] args) {
        readInput();
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