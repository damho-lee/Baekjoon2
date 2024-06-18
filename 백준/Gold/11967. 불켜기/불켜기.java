import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.run());
    }
}

class Solution {
    private boolean[][] shed;
    private Map<Point, List<Point>> switchMap;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public Solution() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = inputs[0];
            int m = inputs[1];
            shed = new boolean[n + 1][n + 1];
            switchMap = new TreeMap<>();

            for (int i = 0; i < m; i++) {
                inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = inputs[0];
                int y = inputs[1];
                int a = inputs[2];
                int b = inputs[3];

                Point from = new Point(x, y);
                Point to = new Point(a, b);

                if (switchMap.containsKey(from)) {
                    switchMap.get(from).add(to);
                } else {
                    List<Point> toList = new ArrayList<>();
                    toList.add(to);
                    switchMap.put(from, toList);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void turnOn() {

        boolean[][] visited = new boolean[shed.length][shed.length];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        shed[1][1] = true;
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (shed[current.getX()][current.getY()] && switchMap.containsKey(current)) {
                for (Point point : switchMap.get(current)) {
                    shed[point.getX()][point.getY()] = true;
                    if (canGo(point.getX(), point.getY()) && !visited[point.getX()][point.getY()]) {
                        queue.add(point);
                        visited[point.getX()][point.getY()] = true;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];

                if (isValid(newX, newY) && shed[newX][newY] && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

    private boolean canGo(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        boolean[][] visited = new boolean[shed.length][shed.length];

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.getX() == x && current.getY() == y) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];

                if (isValid(newX, newY) && shed[newX][newY] && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY));
                }
            }
        }

        return false;
    }

    private boolean isValid(int x, int y) {
        return x > 0 && x < shed.length && y > 0 && y < shed[x].length;
    }

    public int calculate() {
        int count = 0;
        for (int i = 1; i < shed.length; i++) {
            for (int j = 1; j < shed[i].length; j++) {
                if (shed[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public int run() {
        turnOn();
        return calculate();
    }
}

class Point implements Comparable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    @Override
    public int compareTo(Object o) {
        Point other = (Point) o;

        if (this.getX() == other.getX()) {
            return this.getY() - other.getY();
        }

        return this.getX() - other.getX();
    }
}