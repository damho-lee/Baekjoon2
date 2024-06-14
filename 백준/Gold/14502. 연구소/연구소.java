import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    private static int[][] graph;
    private static List<Point> virus;
    private static List<Point> blanks;
    private static Point[] points;
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int column = Integer.parseInt(inputs[1]);
            graph = new int[row][column];
            virus = new ArrayList<>();
            blanks = new ArrayList<>();

            for (int i = 0; i < row; i++) {
                graph[i] = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < graph[i].length; j++) {
                    if (graph[i][j] == 2) {
                        virus.add(new Point(i, j));
                    } else if (graph[i][j] == 0) {
                        blanks.add(new Point(i, j));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int max = 0;
        int newGraph[][];

        for (int i = 0; i < blanks.size(); i++) {
            Point first = blanks.get(i);

            for (int j = i + 1; j < blanks.size(); j++) {
                Point second = blanks.get(j);

                for (int k = j + 1; k < blanks.size(); k++) {
                    Point third = blanks.get(k);
                    newGraph = copyGraph();
                    newGraph[first.getX()][first.getY()] = 1;
                    newGraph[second.getX()][second.getY()] = 1;
                    newGraph[third.getX()][third.getY()] = 1;

                    spread(newGraph);
                    max = Math.max(max, calculateSizeOfSafeZone(newGraph));
                }
            }
        }

        return max;
    }

    private static void spread(int[][] newGraph) {
        Queue<Point> queue = new LinkedList<>();
        for (Point point : virus) {
            queue.add(point);
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];

                if (isValid(newX, newY, newGraph) && newGraph[newX][newY] == 0) {
                    newGraph[newX][newY] = 2;
                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

    private static int calculateSizeOfSafeZone(int[][] newGraph) {
        int count = 0;

        for (int i = 0; i < newGraph.length; i++) {
            for (int j = 0; j < newGraph[i].length; j++) {
                if (newGraph[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValid(int x, int y, int[][] newGraph) {
        return x >= 0 && x < newGraph.length && y >= 0 && y < newGraph[x].length;
    }

    private static int[][] copyGraph() {
        int[][] newArray = new int[graph.length][graph[0].length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                newArray[i][j] = graph[i][j];
            }
        }

        return newArray;
    }

    private static void run() {
        readInput();
        System.out.println(calculate());
    }

    public static void main(String[] args) {
        run();
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