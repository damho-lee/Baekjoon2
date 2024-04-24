import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] field;
    private static int[] dx = new int[]{-1, 0, 0, 1};
    private static int[] dy = new int[]{0, -1, 1, 0};

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            field = new int[n][m];

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    field[i][j] = Integer.parseInt(inputs[j]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int run() {
        int count;
        int result = 0;
        while ((count = calculateArea()) < 2) {
            if (count == 0) {
                result = 0;
                break;
            }

            melt();
            result++;
        }

        return result;
    }

    private static int calculateArea() {
        boolean[][] visited = new boolean[field.length][field[0].length];
        int count = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isValid(newX, newY) && field[newX][newY] != 0 && !visited[newX][newY]) {
                dfs(newX, newY, visited);
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < field.length && y >= 0 && y < field[0].length;
    }

    private static void melt() {
        Queue<IceBerg> queue = new LinkedList<>();
        boolean[][] isIceBerg = new boolean[field.length][field[0].length];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] != 0) {
                    queue.add(new IceBerg(i, j));
                    isIceBerg[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            IceBerg iceBerg = queue.poll();
            int numberOfSea = 0;
            int x = iceBerg.getX();
            int y = iceBerg.getY();
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (field[newX][newY] == 0 && !isIceBerg[newX][newY]) {
                    numberOfSea++;
                }
            }

            field[x][y] = field[x][y] > numberOfSea ? field[x][y] - numberOfSea : 0;
        }
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(run());
    }
}

class IceBerg {
    private int x;
    private int y;

    public IceBerg(int x, int y) {
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