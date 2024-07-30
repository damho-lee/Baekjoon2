import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][][][] field;
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int NOT_ROTATED = 0;
    private static final int ROTATED = 1;
    private static final int DIVISOR = 100000;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int row = Integer.parseInt(stringTokenizer.nextToken());
            int column = Integer.parseInt(stringTokenizer.nextToken());

            field = new int[row + 1][column + 1][2][2];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int row = field.length;
        int column = field[0].length;

        for (int i = 1; i < row; i++) {
            field[i][1][RIGHT][NOT_ROTATED] = 1;
        }

        for (int i = 1; i < column; i++) {
            field[1][i][DOWN][NOT_ROTATED] = 1;
        }

        for (int i = 2; i < row; i++) {
            for (int j = 2; j < column; j++) {
                field[i][j][DOWN][NOT_ROTATED] = (field[i][j - 1][DOWN][NOT_ROTATED] + field[i][j - 1][DOWN][ROTATED]) % DIVISOR;
                field[i][j][DOWN][ROTATED] = field[i][j - 1][RIGHT][NOT_ROTATED] % DIVISOR;
                field[i][j][RIGHT][NOT_ROTATED] = (field[i - 1][j][RIGHT][NOT_ROTATED] + field[i - 1][j][RIGHT][ROTATED]) % DIVISOR;
                field[i][j][RIGHT][ROTATED] = field[i - 1][j][DOWN][NOT_ROTATED] % DIVISOR;
            }
        }

        return (field[row - 1][column - 1][DOWN][ROTATED]
                + field[row - 1][column - 1][DOWN][NOT_ROTATED]
                + field[row - 1][column - 1][RIGHT][ROTATED]
                + field[row - 1][column - 1][RIGHT][NOT_ROTATED]) % DIVISOR;
    }

    public static void main(String[] args) throws IOException {
        readInput();
        System.out.println(calculate());
    }
}
