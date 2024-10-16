import java.io.*;
import java.util.Arrays;
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
        this.input = tmp;

        this.array = new int[lengthOfSequence];
        this.stringBuffer = new StringBuffer();
    }

    public String solve() {
        this.stringBuffer.setLength(0);

        dfs(0, 0);

        return this.stringBuffer.toString();
    }

    private void dfs(int currentIndex, int length) {
        if (length == this.lengthOfSequence) {
            for (int i = 0; i < array.length; i++) {
                stringBuffer.append(array[i]).append(" ");
            }

            stringBuffer.append("\n");
            return;
        }

        for (int i = 0; i < input.length; i++) {
            array[currentIndex] = input[i];
            dfs(currentIndex + 1, length + 1);
        }
    }
}