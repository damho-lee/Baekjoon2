import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<Point> readInput() {
        List<Point> inputList = new ArrayList<>();
        String inputString;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                inputString = reader.readLine().trim();
                StringTokenizer st = new StringTokenizer(inputString);
                inputList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return inputList;
    }

    public static int sumOfLine(List<Point> list) {
        if (list.isEmpty()) {
            return 0;
        }

        int sum = 0;
        Point first = list.get(0);
        int x = first.getX();
        int y = first.getY();

        for (Point point : list) {
            if (x <= point.getX() && point.getX() <= y) {
                y = Math.max(y, point.getY());
            } else {
                sum += y - x;
                x = point.getX();
                y = point.getY();
            }
        }

        sum += y - x;
        return sum;
    }

    public static void main(String[] args) {
        List<Point> sortedPointList = MergeSort.mergeSort(readInput());
        System.out.println(sumOfLine(sortedPointList));
    }
}

class MergeSort {
    private MergeSort() {}

    public static <T extends Comparable> List<T> mergeSort(List<T> list) {
        if (list.size() > 1) {
            return merge(
                    mergeSort(list.subList(0, list.size() / 2)),
                    mergeSort(list.subList(list.size() / 2, list.size())));
        } else {
            return list;
        }
    }

    private static <T extends Comparable> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            T leftElement = left.get(leftIndex);
            T rightElement = right.get(rightIndex);

            if (leftElement.compareTo(rightElement) <= 0) {
                result.add(leftElement);
                leftIndex++;
            } else {
                result.add(rightElement);
                rightIndex++;
            }
        }

        // Add remaining elements from left list
        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex));
            leftIndex++;
        }

        // Add remaining elements from right list
        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex));
            rightIndex++;
        }

        return result;
    }
}

class Point implements Comparable {
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
        return this.getX() - ((Point) o).getX();
    }
}