import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int a, b;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            a = Integer.parseInt(inputs[0].trim());
            b = Integer.parseInt(inputs[1].trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        while (b != a) {
            if (b < a) {
                System.out.println(-1);
                return;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b /= 10;
            } else {
                System.out.println(-1);
                return;
            }

            count++;
        }
        System.out.println(count + 1);
    }
}
