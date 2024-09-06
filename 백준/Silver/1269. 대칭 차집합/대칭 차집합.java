import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            Set<Integer> set1Minus2 = new HashSet<>();
            Set<Integer> set2Minus1 = new HashSet<>();
            int input;

            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            inputs = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                input = Integer.parseInt(inputs[i]);
                set1.add(input);
                set1Minus2.add(input);
            }

            inputs = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                input = Integer.parseInt(inputs[i]);
                set2.add(input);
                set2Minus1.add(input);
            }

            for (Integer i : set2) {
                set1Minus2.remove(i);
            }
            for (Integer i : set1) {
                set2Minus1.remove(i);
            }

            System.out.println(set1Minus2.size() + set2Minus1.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}