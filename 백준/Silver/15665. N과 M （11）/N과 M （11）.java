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
    private Set<String> set;
    private StringBuffer stringBuffer;

    public Solution(int lengthOfSequence, int[] array) {
        this.lengthOfSequence = lengthOfSequence;

        int[] tmp = array.clone();
        Arrays.sort(tmp);
        this.input = Arrays.stream(tmp).distinct().toArray();

        this.array = new int[lengthOfSequence];
        this.set = new HashSet<>();
        this.stringBuffer = new StringBuffer();
    }

    public String solve() {
        dfs(0);

        return this.stringBuffer.toString();
    }

    private void dfs(int currentIndex) {
        if (currentIndex == this.lengthOfSequence) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                stringBuilder.append(array[i]).append(" ");
            }
            String string = stringBuilder.toString();

            if (!set.contains(string)) {
                set.add(string);
                this.stringBuffer.append(string).append("\n");
            }

            return;
        }

        for (int i = 0; i < input.length; i++) {
            array[currentIndex] = input[i];
            dfs(currentIndex + 1);
        }
    }
}