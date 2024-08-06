import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int n, k;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            n = Integer.parseInt(inputs[0]);
            k = Integer.parseInt(inputs[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution(n, k);
        System.out.println(solution.run());
    }
}

class Solution {
    private int n;
    private int k;

    public Solution(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public int run() {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }

        return 0;
    }
}