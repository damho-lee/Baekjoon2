import java.io.*;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            solution = new Solution(n, m);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private final int n;
    private final int lengthOfSequence;
    private int[] sequence;
    private StringBuffer stringBuffer;

    public Solution(int n, int lengthOfSequence) {
        this.n = n;
        this.lengthOfSequence = lengthOfSequence;
        this.sequence = new int[lengthOfSequence];
        this.stringBuffer = new StringBuffer();
    }

    public String solve() {
        this.stringBuffer.setLength(0);

        dfs(0);

        return this.stringBuffer.toString();
    }

    private void dfs(int length) {
        if (length == this.lengthOfSequence) {
            if (isNonDecreasingOrder(this.sequence)) {
                for (int i : sequence) {
                    stringBuffer.append(i).append(" ");
                }

                stringBuffer.append("\n");
            }
            
            return;
        }

        for (int i = 1; i <= n; i++) {
            sequence[length] = i;
            dfs(length + 1);
        }
    }

    private static boolean isNonDecreasingOrder(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }

        return true;
    }
}