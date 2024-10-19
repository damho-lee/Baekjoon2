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
    private final boolean[] visited;
    private Set<String> set;

    public Solution(int lengthOfSequence, int[] array) {
        this.lengthOfSequence = lengthOfSequence;

        int[] tmp = array.clone();
        Arrays.sort(tmp);
        this.input = tmp;

        this.visited = new boolean[input.length];
        this.set = new TreeSet<>((a, b) -> {
            String[] arrayA = a.split(" ");
            String[] arrayB = b.split(" ");

            for (int i = 0; i < arrayA.length; i++) {
                int numA = Integer.parseInt(arrayA[i]);
                int numB = Integer.parseInt(arrayB[i]);

                if (numA != numB) {
                    return numA - numB;
                }
            }

            return 0;
        });
    }

    public String solve() {
        dfs(0);
        StringBuffer stringBuffer = new StringBuffer();

        for (String s : set) {
            stringBuffer.append(s).append("\n");
        }

        return stringBuffer.toString();
    }

    private void dfs(int currentIndex) {
        if (currentIndex == this.lengthOfSequence) {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            for (int i = 0; i < visited.length && count < lengthOfSequence; i++) {
                if (visited[i]) {
                    stringBuilder.append(input[i]).append(" ");
                    count++;
                }
            }
            set.add(stringBuilder.toString());

            return;
        }

        for (int i = currentIndex; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(currentIndex + 1);
                visited[i] = false;
            }
        }
    }
}