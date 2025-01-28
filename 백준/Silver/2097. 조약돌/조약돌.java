import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            long result = 0;
            
            if (n < 3) {
                result = 4;
            } else {
                long x = Math.round(Math.sqrt(n));
                
                if (x * x >= n) {
                    result = (x - 1) * 4;
                } else {
                    result = (x - 1) * 2 + x * 2;
                }
            }
            
            System.out.println(result);
        } catch (IOException e) {
        }
    }
}
