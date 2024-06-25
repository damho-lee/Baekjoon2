import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[][] board;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            board = new int[19][19];

            for (int i = 0; i < board.length; i++) {
                board[i] = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean win(int x, int y) {
        int current = board[x][y];
        int count = 1;

        for (int i = x + 1; i < board.length; i++) {
            if (board[i][y] != current) {
                break;
            }

            count++;
        }

        if (count == 5) {
            if (x - 1 >= 0 && board[x - 1][y] == current) {
                return false;
            }

            return true;
        }

        count = 1;

        for (int i = y + 1; i < board[x].length; i++) {
            if (board[x][i] != current) {
                break;
            }

            count++;
        }

        if (count == 5) {
            if (y - 1 >= 0 && board[x][y - 1] == current) {
                return false;
            }

            return true;
        }

        count = 1;

        for (int i = 1; x + i < board.length && y + i < board[x].length; i++) {
            if (board[x + i][y + i] != current) {
                break;
            }

            count++;
        }

        if (count == 5) {
            if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == current) {
                return false;
            }
            return true;
        }

        count = 1;

        for (int i = 1; x - i >= 0 && y + i < board[x].length; i++) {
            if (board[x - i][y + i] != current) {
                break;
            }

            count++;
        }

        if (count == 5) {
            if (x + 1 < board.length && y - 1 >= 0 && board[x + 1][y - 1] == current) {
                return false;
            }
            return true;
        }

        return false;
    }

    private static String calculate() {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                if (win(i, j)) {
                    buffer.append(board[i][j] + "\n");
                    buffer.append((i + 1));
                    buffer.append(" ");
                    buffer.append((j + 1));
                    return buffer.toString();
                }
            }
        }

        return "0";
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
