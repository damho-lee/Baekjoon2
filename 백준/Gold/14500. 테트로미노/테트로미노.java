import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static List<Shape> shapes;

    private static void init() {
        shapes = new ArrayList<>();

        shapes.add(new Shape(new Delta[]{new Delta(0, 1), new Delta(0, 2), new Delta(0, 3)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(2, 0), new Delta(3, 0)}));
        shapes.add(new Shape(new Delta[]{new Delta(0, 1), new Delta(1, 0), new Delta(1, 1)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(2, 0), new Delta(2, 1)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(0, 1), new Delta(0, 2)}));
        shapes.add(new Shape(new Delta[]{new Delta(0, 1), new Delta(1, 1), new Delta(2, 1)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(1, -1), new Delta(1, -2)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(2, 0), new Delta(2, -1)}));
        shapes.add(new Shape(new Delta[]{new Delta(0, 1), new Delta(0, 2), new Delta(1, 2)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(2, 0), new Delta(0, 1)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(1, 1), new Delta(1, 2)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(1, 1), new Delta(2, 1)}));
        shapes.add(new Shape(new Delta[]{new Delta(0, 1), new Delta(-1, 1), new Delta(-1, 2)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(1, -1), new Delta(2, -1)}));
        shapes.add(new Shape(new Delta[]{new Delta(0, 1), new Delta(1, 1), new Delta(1, 2)}));
        shapes.add(new Shape(new Delta[]{new Delta(0, 1), new Delta(1, 1), new Delta(0, 2)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, -1), new Delta(1, 0), new Delta(2, 0)}));
        shapes.add(new Shape(new Delta[]{new Delta(-1, 1), new Delta(0, 1), new Delta(0, 2)}));
        shapes.add(new Shape(new Delta[]{new Delta(1, 0), new Delta(2, 0), new Delta(1, 1)}));
    }

    private static int[][] readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int row = Integer.parseInt(inputs[0].trim());
            int column = Integer.parseInt(inputs[1].trim());

            int[][] array = new int[row][column];

            for (int i = 0; i < row; i++) {
                inputs = reader.readLine().trim().split(" ");
                array[i] = Stream.of(inputs).mapToInt(Integer::parseInt).toArray();
            }

            return array;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int[][] array) {
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (Shape shape : shapes) {
                    if (shape.isValid(array, i, j)) {
                        max = Math.max(max, shape.sum(array, i, j));
                    }
                }
            }
        }

        return max;
    }

    private static void run() {
        int[][] array = readInput();
        init();
        System.out.println(calculate(array));
    }

    public static void main(String[] args) {
        run();
    }
}

class Shape {
    private Delta[] deltas;

    public Shape(Delta[] deltas) {
        this.deltas = deltas;
    }

    public boolean isValid(int[][] array, int i, int j) {
        for (Delta delta : deltas) {
            int newX = i + delta.getDx();
            int newY = j + delta.getDy();

            if (newX < 0 || newX >= array.length || newY < 0 || newY >= array[i].length) {
                return false;
            }
        }

        return true;
    }

    public int sum(int[][] array, int i, int j) {
        if (!isValid(array, i, j)) {
            throw new IllegalStateException("유효하지 않은 인덱스가 포함되어 있습니다.");
        }

        int sum = array[i][j];

        for (Delta delta : deltas) {
            sum += array[i + delta.getDx()][j + delta.getDy()];
        }

        return sum;
    }
}

class Delta {
    private int dx;
    private int dy;

    public Delta(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}