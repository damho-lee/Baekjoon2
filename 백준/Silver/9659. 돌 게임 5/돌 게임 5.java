import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine().trim();
            int n = Integer.parseInt(input.substring(input.length() - 1));

            System.out.println(n % 2 == 0 ? "CY" : "SK");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}