import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int a1 = Integer.parseInt(inputs[0]);
            int a0 = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(reader.readLine());
            int n0 = Integer.parseInt(reader.readLine());
            if (a1 * n0 + a0 <= c * n0 && c >= a1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } catch (IOException e) {
        }
    }
}
