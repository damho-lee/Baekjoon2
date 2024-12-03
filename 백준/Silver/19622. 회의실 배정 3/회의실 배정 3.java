import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            List<Meeting> list = new ArrayList<>();
            String[] inputs;

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                list.add(new Meeting(
                        Integer.parseInt(inputs[0]),
                        Integer.parseInt(inputs[1]),
                        Integer.parseInt(inputs[2]))
                );

            }

            System.out.println(Solution.calculate(list));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    public static int calculate(List<Meeting> inputs) {
        if (inputs.size() < 2) {
            return inputs.get(0).getNumberOfPersons();
        }
        if (inputs.size() < 3) {
            return Math.max(inputs.get(0).getNumberOfPersons(), inputs.get(1).getNumberOfPersons());
        }

        List<Meeting> list = new ArrayList<>(inputs);
        int[] dp = new int[inputs.size()];

        dp[0] = list.get(0).getNumberOfPersons();
        dp[1] = Math.max(dp[0], list.get(1).getNumberOfPersons());

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + list.get(i).getNumberOfPersons(), dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}

class Meeting {
    private final int start;
    private final int end;
    private final int numberOfPersons;

    public Meeting(int start, int end, int numberOfPersons) {
        this.start = start;
        this.end = end;
        this.numberOfPersons = numberOfPersons;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }
}