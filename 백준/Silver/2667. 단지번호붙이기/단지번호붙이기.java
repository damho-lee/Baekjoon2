import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    private static int[][] graph;
    private static int[] dx = new int[]{-1, 0, 0, 1};
    private static int[] dy = new int[]{0, 1, -1, 0};

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                String input = reader.readLine().trim();
                graph[i] = input.chars().map(Character::getNumericValue).toArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Integer> calculate() {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    list.add(dfs(i, j, visited));
                }
            }
        }

        list.sort(Integer::compareTo);
        return list;
    }

    private static int dfs(int x, int y, boolean[][] visited) {
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(x, y));
        int count = 0;
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            count++;
            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];
                if (isValid(newX, newY) && !visited[newX][newY]) {
                    stack.add(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }

        return count;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[x].length && graph[x][y] != 0;
    }

    private static void print(List<Integer> list) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(list.size()).append("\n");
        for (Integer integer : list) {
            stringBuffer.append(integer).append("\n");
        }

        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        readInput();
        List<Integer> list = calculate();
        print(list);
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
