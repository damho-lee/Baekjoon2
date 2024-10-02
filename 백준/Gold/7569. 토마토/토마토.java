import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int m = Integer.parseInt(inputs[0]);
            int n = Integer.parseInt(inputs[1]);
            int height = Integer.parseInt(inputs[2]);
            int[][][] tomatoes = new int[height][n][m];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < n; j++) {
                    tomatoes[i][j] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                }
            }

            solution = new Solution(tomatoes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solution());
    }

    private static void print(int[][][] array) {
        for (int[][] arr1 : array) {
            for (int[] arr2 : arr1) {
                for (int i : arr2) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}

class Solution {
    private final static int[] heightDelta = new int[]{0, 0, 0, 0, -1, 1};
    private final static int[] rowDelta = new int[]{-1, 1, 0, 0, 0, 0,};
    private final static int[] columnDelta = new int[]{0, 0, -1, 1, 0, 0};
    private int[][][] tomatoes;

    public Solution(int[][][] tomatoes) {
        this.tomatoes = tomatoes;
    }

    public int solution() {
        Queue<Tomato> ripeTomatoes1 = new LinkedList<>();
        Queue<Tomato> ripeTomatoes2 = new LinkedList<>();
        Queue<Tomato>[] queue = new Queue[]{ripeTomatoes1, ripeTomatoes2};
        int day = 0;
        int today;
        int tomorrow;

        for (int height = 0; height < tomatoes.length; height++) {
            for (int row = 0; row < tomatoes[height].length; row++) {
                for (int column = 0; column < tomatoes[height][row].length; column++) {
                    if (tomatoes[height][row][column] == 1) {
                        ripeTomatoes1.offer(new Tomato(height, row, column));
                    }
                }
            }
        }

        while (!ripeTomatoes1.isEmpty() || !ripeTomatoes2.isEmpty()) {
            today = day % 2;
            tomorrow = (day + 1) % 2;

            while (!queue[today].isEmpty()) {
                Tomato tomato = queue[today].poll();
                int height = tomato.getHeight();
                int row = tomato.getRow();
                int column = tomato.getColumn();

                for (int i = 0; i < heightDelta.length; i++) {
                    int newHeight = height + heightDelta[i];
                    int newRow = row + rowDelta[i];
                    int newColumn = column + columnDelta[i];

                    if (isValid(newHeight, newRow, newColumn) && tomatoes[newHeight][newRow][newColumn] == 0) {
                        tomatoes[newHeight][newRow][newColumn] = 1;
                        queue[tomorrow].offer(new Tomato(newHeight, newRow, newColumn));
                    }
                }
            }


            day++;
        }

        if (isAllRipened()) {
            return day - 1;
        } else {
            return -1;
        }
    }

    private boolean isValid(int height, int row, int column) {
        return height >= 0 && height < this.tomatoes.length
                && row >= 0 && row < this.tomatoes[height].length
                && column >= 0 && column < this.tomatoes[height][row].length;
    }

    private boolean isAllRipened() {
        for (int i = 0; i < tomatoes.length; i++) {
            for (int j = 0; j < tomatoes[i].length; j++) {
                for (int k = 0; k < tomatoes[i][j].length; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

class Tomato {
    private int height;
    private int row;
    private int column;

    public Tomato(int height, int row, int column) {
        this.height = height;
        this.row = row;
        this.column = column;
    }

    public int getHeight() {
        return height;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}