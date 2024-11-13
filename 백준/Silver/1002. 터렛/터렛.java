import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] inputs;

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                int x1 = Integer.parseInt(inputs[0]);
                int y1 = Integer.parseInt(inputs[1]);
                int r1 = Integer.parseInt(inputs[2]);
                int x2 = Integer.parseInt(inputs[3]);
                int y2 = Integer.parseInt(inputs[4]);
                int r2 = Integer.parseInt(inputs[5]);

                Point p1 = new Point(x1, y1, r1);
                Point p2 = new Point(x2, y2, r2);

                writer.write(Solution.solve(p1, p2) + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private static final int INF = -1;

    private Solution() {
    }

    public static int solve(Point p1, Point p2) {
        int subOfRadius = Math.abs(p1.getRadius() - p2.getRadius());
        int sumOfRadius = p1.getRadius() + p2.getRadius();
        double distance = calculateDistance(p1, p2);

        if (distance == 0 && p1.getRadius() == p2.getRadius()) {
            // 두 원의 중심이 같고 반지름이 같음 (무한대의 접점)
            return INF;
        } else if (distance > sumOfRadius || distance < subOfRadius) {
            // 두 원이 떨어져 있거나 한 원이 다른 원의 내부에 있으면서 접하지 않음
            return 0;
        } else if (distance == sumOfRadius || distance == subOfRadius) {
            // 두 원이 외접 또는 내접
            return 1;
        } else {
            // 두 원이 두 점에서 만남
            return 2;
        }
    }

    private static double calculateDistance(Point p1, Point p2) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}

class Point {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;
        return x == point.x && y == point.y && radius == point.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, radius);
    }

    private final int x;
    private final int y;
    private final int radius;

    public Point(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}
