import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static char[][] readInput() {
        char[][] board;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int r = Integer.parseInt(inputs[0]);
            int c = Integer.parseInt(inputs[1]);
            board = new char[r][c];
            for (int i = 0; i < r; i++) {
                String inputString = reader.readLine();
                for (int j = 0; j < c; j++) {
                    board[i][j] = inputString.charAt(j);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return board;
    }

    public static void main(String[] args) {
        char[][] board = readInput();
        Calculator calculator = new Calculator(board);
        System.out.println(calculator.calculateSpaces());
    }
}

class Calculator {
    private char[][] board;
    private boolean[] visited;
    private int max;
    private int[] dx;
    private int[] dy;

    public Calculator(char[][] board) {
        this.board = board;
        this.visited = new boolean[26];
        this.max = 1;
        dx = new int[]{-1, 0, 0, 1};
        dy = new int[]{0, -1, 1, 0};
    }

    public int calculateSpaces() {
        if (this.max > 1) {
            init();
        }

        dfs(0, 0, 0);
        return this.max;
    }
    private void init() {
        this.max = 1;
        this.visited = new boolean[26];
    }

    private boolean isValid(int x, int y) {
        try {
            char ch = board[x][y];
        } catch (IndexOutOfBoundsException exception) {
            return false;
        }

        return true;
    }

    private void dfs(int x, int y, int count) {
        if (visited[board[x][y] - 'A']) {
            max = Math.max(max, count);
            return;
        }

        visited[board[x][y] - 'A'] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isValid(newX, newY)) {
                dfs(newX, newY, count + 1);
            }
        }

        visited[board[x][y] - 'A'] = false;
    }
}