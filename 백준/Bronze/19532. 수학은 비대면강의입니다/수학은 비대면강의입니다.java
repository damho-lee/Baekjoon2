import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            int d = Integer.parseInt(inputs[3]);
            int e = Integer.parseInt(inputs[4]);
            int f = Integer.parseInt(inputs[5]);

            int x = (b * f - c * e) / (b * d - a * e);
            int y = (a * f - d * c) / (a * e - b * d);
            System.out.println(x + " " + y);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
