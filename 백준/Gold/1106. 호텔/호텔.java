import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = reader.readLine().split(" ");
            int c = Integer.parseInt(input[0]);
            int numberOfCity = Integer.parseInt(input[1]);
            List<City> cityList = new ArrayList<>();

            for (int i = 0; i < numberOfCity; i++) {
                input = reader.readLine().split(" ");
                int cost = Integer.parseInt(input[0]);
                int people = Integer.parseInt(input[1]);

                cityList.add(new City(cost, people));
            }

            writer.write(calculate(c, cityList) + "");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int c, List<City> cityList) {
        int[] dp = new int[c + 101];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (City city : cityList) {
            int cost = city.getCost();
            int people = city.getPeople();

            for (int i = people; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], cost + dp[i - people]);
            }
        }

        return findMinValue(dp, c);
    }

    private static int findMinValue(int[] array, int startIndex) {
        int min = INF;

        for (int i = startIndex; i < array.length; i++) {
            min = Math.min(min, array[i]);
        }

        return min;
    }
}

final class City {
    private final int cost;
    private final int people;

    public City(int cost, int people) {
        this.cost = cost;
        this.people = people;
    }

    public int getCost() {
        return cost;
    }

    public int getPeople() {
        return people;
    }
}