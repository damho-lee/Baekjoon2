import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    private static List<Integer>[] family;
    private static int person1;
    private static int person2;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            family = new List[n + 1];
            for (int i = 0; i < family.length; i++) {
                family[i] = new ArrayList<>();
            }

            String[] inputs = reader.readLine().trim().split(" ");
            person1 = Integer.parseInt(inputs[0].trim());
            person2 = Integer.parseInt(inputs[1].trim());

            n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().trim().split(" ");
                int parent = Integer.parseInt(inputs[0]);
                int child = Integer.parseInt(inputs[1]);
                family[parent].add(child);
                family[child].add(parent);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() {
        int[] degree = new int[family.length];
        for (int i = 0; i < degree.length; i++) {
            degree[i] = -1;
        }
        dfs(person1, 0, degree);
        System.out.println(degree[person2]);
    }

    private static void dfs(int start, int count, int[] degree) {
        degree[start] = count++;
        for (int child : family[start]) {
            if (degree[child] == -1) {
                dfs(child, count, degree);
            }
        }
    }

    public static void main(String[] args) {
        readInput();
        run();
    }
}
