import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long n = Long.parseLong(reader.readLine());
            long sum = 0;

            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                sum += Long.parseLong(st.nextToken());
            }

            System.out.println(sum - (n * (n - 1) / 2));
        } catch (IOException e) {
        }
    }
}