import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int start = 1;
            int end = 1;
            int sum = 1;
            int count = 1;

            while (start < n) {
                if (sum < n) {
                    end++;
                    sum += end;
                } else if (sum > n) {
                    sum -= start;
                    start++;
                } else {
                    count++;
                    end++;
                    sum += end;
                }
            }

            System.out.println(count);
        } catch (IOException e) {
        }
    }
}