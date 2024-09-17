import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Stack<Integer> stack = new Stack<>();
            int n = Integer.parseInt(reader.readLine().trim());
            int number;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                number = Integer.parseInt(reader.readLine().trim());
                if (number == 0) {
                    stack.pop();
                } else {
                    stack.push(number);
                }
            }

            for (Integer integer : stack) {
                sum += integer;
            }
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}