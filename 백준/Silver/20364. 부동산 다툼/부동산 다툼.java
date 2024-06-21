import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
    }
}

class Solution {
    private boolean[] lands;
    private int[] ducks;

    public Solution() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int numberOfLand = inputs[0];
            int numberOfDuck = inputs[1];
            lands = new boolean[numberOfLand + 1];
            ducks = new int[numberOfDuck];

            for (int i = 0; i < numberOfDuck; i++) {
                ducks[i] = Integer.parseInt(reader.readLine().trim());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String solve() {
        StringBuffer buffer = new StringBuffer();

        for (int duck : ducks) {
            buffer.append(search(duck));
            buffer.append("\n");
        }

        return buffer.toString();
    }

    public int search(int landNumber) {
        int index = landNumber;
        LinkedList<Integer> list = new LinkedList<>();

        while (index > 0) {
            list.addFirst(index);
            index /= 2;
        }

        for (Integer i : list) {
            if (lands[i]) {
                return i;
            }
        }

        lands[landNumber] = true;
        return 0;
    }
}
