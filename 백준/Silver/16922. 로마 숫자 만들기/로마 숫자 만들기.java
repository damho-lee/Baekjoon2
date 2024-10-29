import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int n;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().trim());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Solution.solve(n));
    }
}

class Solution {
    private Solution() {
    }

    private static final int I = 1;
    private static final int V = 5;
    private static final int X = 10;
    private static final int L = 50;

    public static int solve(int n) {
        Set<Integer> set = new HashSet<>();

        for (int numberOfI = 0; numberOfI <= n; numberOfI++) {
            for (int numberOfV = 0; numberOfV <= n - numberOfI; numberOfV++) {
                for (int numberOfX = 0; numberOfX <= n - numberOfI - numberOfV; numberOfX++) {
                    int numberOfL = n - numberOfI - numberOfV - numberOfX;
                    int sum = I * numberOfI
                            + V * numberOfV
                            + X * numberOfX
                            + L * numberOfL;
                    set.add(sum);
                }
            }
        }

        return set.size();
    }
}