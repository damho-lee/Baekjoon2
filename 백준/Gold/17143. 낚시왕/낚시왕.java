import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate());
    }
}

class Solution {
    private int[][] fishingHole;
    private Shark[] sharks;
    private static final int EMPTY = -1;
    private Delta[] direction = new Delta[]{new Delta(-1, 0), new Delta(1, 0), new Delta(0, 1), new Delta(0, -1)};

    public Solution() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int r = inputs[0];
            int c = inputs[1];
            int m = inputs[2];
            sharks = new Shark[m];

            fishingHole = new int[r + 1][c + 1];
            init();

            for (int i = 0; i < m; i++) {
                inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int directionIndex = inputs[3] - 1;
                sharks[i] = new Shark((char) ('A' + i), inputs[0], inputs[1], inputs[2], new Delta(direction[directionIndex].getDr(), direction[directionIndex].getDc()), inputs[4]);
                fishingHole[inputs[0]][inputs[1]] = i;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int calculate() {
        int sumOfSize = 0;
        int kingIndex = 0;

        while (kingIndex < fishingHole[0].length - 1) {
            kingIndex++;
            int sharkIndex = fish(kingIndex);
            if (sharkIndex != -1) {
                sumOfSize += sharks[sharkIndex].getSize();
                sharks[sharkIndex] = null;
            }
            init();

            for (int i = 0; i < sharks.length; i++) {
                if (sharks[i] == null) {
                    continue;
                }

                move(sharks[i]);
                Point current = new Point(sharks[i].getR(), sharks[i].getC());

                if (fishingHole[current.getR()][current.getC()] != -1) {
                    int tmp = fishingHole[current.getR()][current.getC()];
                    int biggerSharkIndex = tmp;
                    int smallerSharkIndex = i;

                    if (sharks[tmp].getSize() < sharks[i].getSize()) {
                        biggerSharkIndex = i;
                        smallerSharkIndex = tmp;
                    }

                    fishingHole[current.getR()][current.getC()] = biggerSharkIndex;
                    sharks[smallerSharkIndex] = null;
                } else {
                    fishingHole[sharks[i].getR()][sharks[i].getC()] = i;
                }
            }
        }

        return sumOfSize;
    }

    private void init() {
        for (int i = 0; i < fishingHole.length; i++) {
            for (int j = 0; j < fishingHole[i].length; j++) {
                fishingHole[i][j] = EMPTY;
            }
        }
    }

    private int fish(int humanIndex) {
        for (int i = 1; i < fishingHole.length; i++) {
            if (fishingHole[i][humanIndex] != -1) {
                return fishingHole[i][humanIndex];
            }
        }

        return -1;
    }

    private void move(Shark shark) {
        for (int i = 0; i < shark.getSpeed(); i++) {
            if (isFacingTheWall(shark)) {
                shark.reverse();
            }

            shark.move();
        }
    }

    private boolean isFacingTheWall(Shark shark) {
        int newR = shark.getR() + shark.getDelta().getDr();
        int newC = shark.getC() + shark.getDelta().getDc();

        return !(newR > 0 && newR < fishingHole.length && newC > 0 && newC < fishingHole[0].length);
    }
}

class Shark {
    private char name;
    private Point location;
    private int speed;
    private Delta delta;
    private int size;

    public Shark(char name, int r, int c, int speed, Delta delta, int size) {
        this.name = name;
        this.location = new Point(r, c);
        this.speed = speed;
        this.delta = delta;
        this.size = size;
    }

    public char getName() {
        return name;
    }

    public int getR() {
        return location.getR();
    }

    public int getC() {
        return location.getC();
    }

    public int getSpeed() {
        return speed;
    }

    public Delta getDelta() {
        return delta;
    }

    public int getSize() {
        return size;
    }

    public void reverse() {
        this.delta.reverse();
    }

    public void move() {
        this.location.move(delta);
    }
}

class Point {
    private int r;
    private int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public void move(Delta delta) {
        this.r += delta.getDr();
        this.c += delta.getDc();
    }
}

class Delta {
    private int dr;
    private int dc;

    public Delta(int dr, int dc) {
        this.dr = dr;
        this.dc = dc;
    }

    public int getDr() {
        return dr;
    }

    public int getDc() {
        return dc;
    }

    public void reverse() {
        this.dr *= -1;
        this.dc *= -1;
    }
}