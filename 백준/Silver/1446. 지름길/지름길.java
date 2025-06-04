import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<ShortCut> shortCutList = new ArrayList<>();
        int destination;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int numberOfShortCut = Integer.parseInt(inputs[0]);
            destination = Integer.parseInt(inputs[1]);

            for (int i = 0; i < numberOfShortCut; i++) {
                inputs = reader.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);
                int weight = Integer.parseInt(inputs[2]);

                shortCutList.add(new ShortCut(start, end, weight));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Solution.solve(shortCutList, destination));
    }
}

final class Solution {
    private Solution() {}

    public static int solve(List<ShortCut> shortCutList, int destination) {
        Queue<ShortCut> validShortCutQueue = new LinkedList<>(getValidShortCutList(shortCutList, destination));
        int[] dp = new int[destination + 1];
        for (int i = 0; i <= destination; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            while (!validShortCutQueue.isEmpty()) {
                ShortCut shortCut = validShortCutQueue.peek();

                if (shortCut.getEnd() != i) {
                    break;
                }

                int start = shortCut.getStart();
                int weight = shortCut.getWeight();

                dp[i] = Math.min(dp[i], dp[start] + weight);
                validShortCutQueue.poll();
            }
        }

        return dp[destination];
    }

    private static List<ShortCut> getValidShortCutList(List<ShortCut> shortCutList, int destination) {
        return shortCutList.stream()
                .filter(shortCut -> shortCut.getWeight() < shortCut.getEnd() - shortCut.getStart())
                .filter(shortCut -> shortCut.getEnd() <= destination)
                .sorted(Comparator.comparingInt(ShortCut::getEnd))
                .collect(Collectors.toList());
    }
}

class ShortCut {
    private final int start;
    private final int end;
    private final int weight;

    public ShortCut(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }
}