import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] dy = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
    private static int[][] board;
    private static Point from;
    private static Point to;

    private static void readInput(BufferedReader reader) throws IOException {
        int l = Integer.parseInt(reader.readLine().trim());
        board = new int[l][l];
        String[] inputs = reader.readLine().trim().split(" ");
        from = new Point(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        inputs = reader.readLine().trim().split(" ");
        to = new Point(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
    }

    private static String calculate() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.getX() == to.getX() && current.getY() == to.getY()) {
                return String.valueOf(board[current.getX()][current.getY()]);
            }

            for (int i = 0; i < 8; i++) {
                int newX = current.getX() + dx[i];
                int newY = current.getY() + dy[i];
                if (isValid(newX, newY) && board[newX][newY] == 0) {
                    board[newX][newY] = board[current.getX()][current.getY()] + 1;
                    queue.add(new Point(newX, newY));
                }
            }
        }

        return String.valueOf(-1);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }

    private static void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < n; i++) {
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