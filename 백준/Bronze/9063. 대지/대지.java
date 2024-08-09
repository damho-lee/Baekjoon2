import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        try (BufferedReader reader = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)))) {
            String[] inputs;
            int x;
            int y;

            int n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                x = Integer.parseInt(inputs[0]);
                y = Integer.parseInt(inputs[1]);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println((maxX - minX) * (maxY - minY));
    }
}
