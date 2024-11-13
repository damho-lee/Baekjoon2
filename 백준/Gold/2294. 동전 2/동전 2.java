import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(reader.readLine().trim()));
            }

            System.out.println(Solution.solve(list, k));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private static final int IMPOSSIBLE = -1;
    private Solution() {}

    public static int solve(List<Integer> list, int key) {
        List<Integer> sortedList = new ArrayList<>(list);
        list.sort(Integer::compareTo);

        int result = calculate(sortedList, key);
        return result == INF ? IMPOSSIBLE : result;
    }

    private static int calculate(List<Integer> list, int key) {
        int[] coins = new int[key + 1];
        Arrays.fill(coins, INF);
        coins[0] = 0;

        for (Integer coin : list) {
            for (int j = coin; j < coins.length; j++) {
                if (coins[j - coin] != INF) {
                    coins[j] = Math.min(coins[j], coins[j - coin] + 1);
                }
            }
        }

        return coins[key];
    }
}