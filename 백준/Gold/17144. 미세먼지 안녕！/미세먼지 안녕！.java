import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int[][] room;
    private static int time;
    private static int[] dr = new int[]{-1, 1, 0, 0};
    private static int[] dc = new int[]{0, 0, -1, 1};
    private static List<Integer> airCleaner;

    private static void readInput() {
        airCleaner = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int r = Integer.parseInt(inputs[0]);
            int c = Integer.parseInt(inputs[1]);
            time = Integer.parseInt(inputs[2]);

            room = new int[r][c];

            for (int i = 0; i < r; i++) {
                inputs = reader.readLine().trim().split(" ");

                for (int j = 0; j < c; j++) {
                    room[i][j] = Integer.parseInt(inputs[j]);

                    if (room[i][j] == -1) {
                        airCleaner.add(i);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void spread() {
        Queue<SpreadObject> objects = new LinkedList<>();

        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] > 0) {
                    objects.add(new SpreadObject(i, j, room[i][j] / 5));
                }
            }
        }

        for (SpreadObject object : objects) {
            int count = 0;
            int r = object.getR();
            int c = object.getC();

            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if (isValid(newR, newC) && !isAirCleaner(newR, newC)) {
                    room[newR][newC] += object.getAmount();
                    count++;
                }
            }

            room[r][c] -= object.getAmount() * count;
        }
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < room.length && c >= 0 && c < room[r].length;
    }

    private static boolean isAirCleaner(int r, int c) {
        return room[r][c] == -1;
    }

    private static void clean() {
        int upperPart = airCleaner.get(0);
        int lowerPart = airCleaner.get(1);
        int maxR = room.length - 1;
        int maxC = room[0].length - 1;

        // 상층부 순환
        for (int i = upperPart - 2; i >= 0; i--) {
            room[i + 1][0] = room[i][0];
        }

        for (int i = 1; i <= maxC; i++) {
            room[0][i - 1] = room[0][i];
        }

        for (int i = 1; i <= upperPart; i++) {
            room[i - 1][maxC] = room[i][maxC];
        }

        for (int i = maxC - 1; i > 0; i--) {
            room[upperPart][i + 1] = room[upperPart][i];
        }

        room[upperPart][1] = 0;

        // 하층부 순환
        for (int i = lowerPart + 2; i <= maxR; i++) {
            room[i - 1][0] = room[i][0];
        }

        for (int i = 1; i <= maxC; i++) {
            room[maxR][i - 1] = room[maxR][i];
        }

        for (int i = maxR - 1; i >= lowerPart; i--) {
            room[i + 1][maxC] = room[i][maxC];
        }

        for (int i = maxC - 1; i > 0; i--) {
            room[lowerPart][i + 1] = room[lowerPart][i];
        }

        room[lowerPart][1] = 0;
    }

    private static int calculate() {
        int sumOfFineDust = 0;

        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                sumOfFineDust += room[i][j];
            }
        }

        return sumOfFineDust + 2;
    }

    private static void print() {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void run() {
        readInput();

        for (int i = 0; i < time; i++) {
            spread();
            clean();
        }

        System.out.println(calculate());
    }

    public static void main(String[] args) {
        run();
    }
}

class SpreadObject {
    private int r;
    private int c;
    private int amount;

    public SpreadObject(int r, int c, int amount) {
        this.r = r;
        this.c = c;
        this.amount = amount;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getAmount() {
        return amount;
    }
}