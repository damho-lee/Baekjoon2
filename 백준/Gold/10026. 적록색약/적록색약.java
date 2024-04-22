import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] rowDelta = new int[]{-1, 0, 0, 1};
    private static int[] columnDelta = new int[]{0, 1, -1, 0};
    private static boolean[][] visited;

    private static char[][] readInput() {
        char[][] painting;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            painting = new char[n][n];
            for (int i = 0; i < n; i++) {
                String inputs = reader.readLine().trim();
                for (int j = 0; j < n; j++) {
                    painting[i][j] = inputs.charAt(j);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return painting;
    }

    private static void initVisitedArray(int rowLength, int columnLength) {
        visited = new boolean[rowLength][columnLength];
    }

    private static void changeGToR(char[][] painting) {
        for (int i = 0; i < painting.length; i++) {
            for (int j = 0; j < painting[i].length; j++) {
                if (painting[i][j] == 'G') {
                    painting[i][j] = 'R';
                }
            }
        }
    }

    private static int calculateNumberOfZones(char[][] painting) {
        int count = 0;
        for (int i = 0; i < painting.length; i++) {
            for (int j = 0; j < painting.length; j++) {
                if (!visited[i][j]) {
                    dfs(painting, i, j, painting[i][j]);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] painting, int x, int y, char ch) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + rowDelta[i];
            int newY = y + columnDelta[i];
            if (newX < 0 || newY < 0 || newX >= painting.length || newY >= painting.length) {
                continue;
            }

            if (!visited[newX][newY] && painting[newX][newY] == ch) {
                dfs(painting, newX, newY, ch);
            }
        }
    }

    public static void main(String[] args) {
        char[][] painting = readInput();
        initVisitedArray(painting.length, painting.length);
        int normalCase = calculateNumberOfZones(painting);

        changeGToR(painting);
        initVisitedArray(painting.length, painting.length);
        int redGreenColorBlindnessCase = calculateNumberOfZones(painting);
        System.out.println(normalCase + " " + redGreenColorBlindnessCase);
    }
}
