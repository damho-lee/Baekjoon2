import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static char[][] picture;
    private static List<Point> baseSides;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            picture = new char[Integer.parseInt(inputs[0])][Integer.parseInt(inputs[1])];

            for (int i = 0; i < picture.length; i++) {
                picture[i] = reader.readLine().trim().toCharArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void findBaseSides() {
        baseSides = new ArrayList<>();

        for (int j = 0; j < picture[0].length; j++) {
            for (int i = picture.length - 1; i >= 0; i--) {
                if (picture[i][j] == 'X') {
                    baseSides.add(new Point(i, j));
                    break;
                }
            }
        }
    }

    private static void restore() {
        int distance = Integer.MAX_VALUE;

        for (Point baseSide : baseSides) {
            int i = baseSide.getX();
            int j = baseSide.getY();

            while (i < picture.length && picture[i + 1][j] != '#') {
                i++;
            }

            distance = Math.min(distance, i - baseSide.getX());
        }

        for (Point baseSide : baseSides) {
            int x = baseSide.getX();
            int y = baseSide.getY();

            for (; x >= 0; x--) {
                if (picture[x][y] == 'X') {
                    picture[x + distance][y] = 'X';
                    picture[x][y] = '.';
                } else {
                    picture[x + distance][y] = '.';
                }
            }
        }
    }

    private static void print() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[i].length; j++) {
                    bufferedWriter.write(picture[i][j]);
                }
                bufferedWriter.write("\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        readInput();
        findBaseSides();
        restore();
        print();
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
