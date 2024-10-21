import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int[] array = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            solution = new Solution(m, array);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private final int lengthOfSequence;
    private final int[] input;
    private final int[] array;
    private StringBuffer stringBuffer;

    public Solution(int lengthOfSequence, int[] array) {
        this.lengthOfSequence = lengthOfSequence;

        int[] tmp = array.clone();
        Arrays.sort(tmp);
        this.input = Arrays.stream(tmp).distinct().toArray();

        this.array = new int[lengthOfSequence];
        this.stringBuffer = new StringBuffer();
    }

    public String solve() {
        dfs(0);

        return this.stringBuffer.toString();
    }

    private void dfs(int currentIndex) {
        if (currentIndex == this.lengthOfSequence) {
            if (isNonDecreasing(this.array)) {
                for (int i = 0; i < array.length; i++) {
                    this.stringBuffer.append(array[i]).append(" ");
                }
                this.stringBuffer.append("\n");
            }

            return;
        }

        for (int i = 0; i < input.length; i++) {
            array[currentIndex] = input[i];
            dfs(currentIndex + 1);
        }
    }

    private static boolean isNonDecreasing(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }

        return true;
    }
}