import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            String input = reader.readLine().trim();
            int chicken = 0;
            int other = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'C') {
                    chicken++;
                } else {
                    other++;
                }
            }

            int result = (int) Math.ceil((double) chicken / (double) (other + 1));
            System.out.println(result);
        } catch (IOException e) {
        }
    }
}