import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static char[][] board;
    private static Point redBall;
    private static Point blueBall;
    private static Point hole;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int column = Integer.parseInt(inputs[1]);
            board = new char[row][column];

            for (int i = 0; i < row; i++) {
                board[i] = reader.readLine().trim().toCharArray();
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'O') {
                        hole = new Point(i, j);
                    } else if (board[i][j] == 'R') {
                        redBall = new Point(i, j);
                    } else if (board[i][j] == 'B') {
                        blueBall = new Point(i, j);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    private static int calculate() {
        Queue<Snapshot> queue = new LinkedList<>();
        queue.add(new Snapshot(redBall.getX(), redBall.getY(), blueBall.getX(), blueBall.getY(), 1));
        boolean visited[][][][] = new boolean[board.length][board[0].length][board.length][board[0].length];
        visited[redBall.getX()][redBall.getY()][blueBall.getX()][blueBall.getY()] = true;

        while (!queue.isEmpty()) {
            Snapshot current = queue.poll();
            int currentRedBallX = current.getRedX();
            int currentRedBallY = current.getRedY();
            int currentBlueBallX = current.getBlueX();
            int currentBlueBallY = current.getBlueY();
            int currentCount = current.getCount();

            if (currentCount > 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newRedBallX = currentRedBallX;
                int newRedBallY = currentRedBallY;
                int newBlueBallX = currentBlueBallX;
                int newBlueBallY = currentBlueBallY;
                boolean isRedBallHole = false;
                boolean isBlueBallHole = false;

                while (board[newRedBallX + dx[i]][newRedBallY + dy[i]] != '#') {
                    newRedBallX += dx[i];
                    newRedBallY += dy[i];

                    if (newRedBallX == hole.getX() && newRedBallY == hole.getY()) {
                        isRedBallHole = true;
                        break;
                    }
                }

                while (board[newBlueBallX + dx[i]][newBlueBallY + dy[i]] != '#') {
                    newBlueBallX += dx[i];
                    newBlueBallY += dy[i];

                    if (newBlueBallX == hole.getX() && newBlueBallY == hole.getY()) {
                        isBlueBallHole = true;
                        break;
                    }
                }

                if (isBlueBallHole) {
                    continue;
                } else if (isRedBallHole) {
                    return currentCount;
                }

                if (isSamePosition(newRedBallX, newRedBallY, newBlueBallX, newBlueBallY)) {
                    if (i == 0) {
                        if (currentRedBallX < currentBlueBallX) {
                            newBlueBallX -= dx[i];
                        } else {
                            newRedBallX -= dx[i];
                        }
                    } else if (i == 1) {
                        if (currentRedBallX > currentBlueBallX) {
                            newBlueBallX -= dx[i];
                        } else {
                            newRedBallX -= dx[i];
                        }
                    } else if (i == 2) {
                        if (currentRedBallY < currentBlueBallY) {
                            newBlueBallY -= dy[i];
                        } else {
                            newRedBallY -= dy[i];
                        }
                    } else {
                        if (currentRedBallY > currentBlueBallY) {
                            newBlueBallY -= dy[i];
                        } else {
                            newRedBallY -= dy[i];
                        }
                    }
                }

                if (!visited[newRedBallX][newRedBallY][newBlueBallX][newBlueBallY]) {
                    visited[newRedBallX][newRedBallY][newBlueBallX][newBlueBallY] = true;
                    queue.add(new Snapshot(newRedBallX, newRedBallY, newBlueBallX, newBlueBallY, currentCount + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isSamePosition(int x1, int y1, int x2, int y2) {
        return x1 == x2 && y1 == y2;
    }

    private static void run() {
        readInput();
        System.out.println(calculate());
    }

    public static void main(String[] args) {
        run();
    }
}

class Snapshot {
    private int redX;
    private int redY;
    private int blueX;
    private int blueY;
    private int count;

    public Snapshot(int redX, int redY, int blueX, int blueY, int count) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.count = count;
    }

    public int getRedX() {
        return redX;
    }

    public int getRedY() {
        return redY;
    }

    public int getBlueX() {
        return blueX;
    }

    public int getBlueY() {
        return blueY;
    }

    public int getCount() {
        return count;
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