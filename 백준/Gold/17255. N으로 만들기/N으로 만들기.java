import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String number = reader.readLine().trim();
            solution = new Solution(number);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private final HashSet<String> set;
    private final String number;

    public Solution(String number) {
        this.set = new HashSet<>();
        this.number = number;
    }

    public int solve() {
        for (int i = 0; i < number.length(); i++) {
            dfs(i, i, "" + number.charAt(i), "" + number.charAt(i));
        }

        return set.size();
    }

    private void dfs(int left, int right, String numStr, String path) {
        if (left == 0 && right == number.length() - 1) {
            set.add(path);
            return;
        }

        if (left - 1 >= 0) {
            dfs(left - 1, right, number.charAt(left - 1) + numStr, path + " " + number.charAt(left - 1) + numStr);
        }
        if (right + 1 < number.length()) {
            dfs(left, right + 1, numStr + number.charAt(right + 1), path + " " + numStr + number.charAt(right + 1));
        }
    }
}
