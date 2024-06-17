import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.run());
    }
}

class Solution {
    private List<Point> chickens;
    private List<Point> houses;
    private List<Point> selectedChickens;
    private int select;
    private int result;

    public Solution() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = inputs[0];
            select = inputs[1];
            chickens = new ArrayList<>();
            houses = new ArrayList<>();
            selectedChickens = new ArrayList<>();
            result = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    if (inputs[j] == 1) {
                        houses.add(new Point(i + 1, j + 1));
                    } else if (inputs[j] == 2) {
                        chickens.add(new Point(i + 1, j + 1));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int run() {
        calculate(0, 0);
        return result;
    }

    private void calculate(int start, int count) {
        if (count == select) {
            int sum = 0;

            for (Point house : houses) {
                int minChickenDistance = Integer.MAX_VALUE;
                int distance = 0;
                for (Point selectedChicken : selectedChickens) {
                    distance = Math.abs(house.getX() - selectedChicken.getX()) + Math.abs(house.getY() - selectedChicken.getY());
                    minChickenDistance = Math.min(minChickenDistance, distance);
                }

                sum += minChickenDistance;
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selectedChickens.add(chickens.get(i));
            calculate(i + 1, count + 1);
            selectedChickens.remove(selectedChickens.size() - 1);
        }
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