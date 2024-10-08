import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            int l = Integer.parseInt(inputs[0]);
            char[] chars = reader.readLine().replace(" ", "").toCharArray();
            solution = new Solution(l, chars);

            writer.write(solution.solve());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

final class Solution {
    private final int lengthOfPassword;
    private final char[] candidates;
    private boolean[] visited;
    private final StringBuffer stringBuffer;

    public Solution(int lengthOfPassword, char[] candidates) {
        this.lengthOfPassword = lengthOfPassword;
        char[] tmp = candidates.clone();
        Arrays.sort(tmp);
        this.candidates = tmp;
        this.visited = new boolean[candidates.length];
        this.stringBuffer = new StringBuffer();
    }

    public String solve() {
        dfs(0, 0);

        return this.stringBuffer.toString();
    }

    private void dfs(int current, int length) {
        StringBuffer tmp = new StringBuffer();
        if (length == lengthOfPassword) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    tmp.append(candidates[i]);
                }
            }

            if (isValid(tmp.toString())) {
                stringBuffer.append(tmp).append("\n");
            }

            return;
        }

        for (int i = current; i < candidates.length; i++) {
            visited[i] = true;
            dfs(i + 1, length + 1);
            visited[i] = false;
        }
    }

    private boolean isValid(String string) {
        int numberOfVowel = 0;
        int numberOfConsonant = 0;

        for (char ch : string.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                numberOfVowel++;
            } else {
                numberOfConsonant++;
            }
        }

        return numberOfVowel >= 1 && numberOfConsonant >= 2;
    }
}