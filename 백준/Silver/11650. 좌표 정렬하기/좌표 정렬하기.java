import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            StringTokenizer stringTokenizer;
            PriorityQueue<Point> queue = new PriorityQueue<>(Point::compareTo);

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                queue.add(new Point(x, y));
            }

            while(!queue.isEmpty()) {
                writer.write(String.valueOf(queue.poll()));
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Point implements Comparable{
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

    @Override
    public int compareTo(Object o) {
        Point other = (Point) o;

        if (this.getX() == other.getX()) {
            return this.getY() - other.getY();
        }

        return this.getX() - other.getX();
    }

    @Override
    public String toString() {
        return this.getX() + " " + this.getY();
    }
}