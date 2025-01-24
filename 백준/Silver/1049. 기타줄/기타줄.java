import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int bundle = Integer.MAX_VALUE;
            int piece = Integer.MAX_VALUE;
            int result = 0;

            for (int i = 0; i < m; i++) {
                inputs = reader.readLine().split(" ");
                bundle = Math.min(bundle, Integer.parseInt(inputs[0]));
                piece = Math.min(piece, Integer.parseInt(inputs[1]));
            }

            if (bundle < piece * 6) {
                result += bundle * (n / 6);
                n %= 6;

                if (bundle < piece * n) {
                    result += bundle;
                } else {
                    result += piece * n;
                }
            } else {
                result += piece * n;
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}