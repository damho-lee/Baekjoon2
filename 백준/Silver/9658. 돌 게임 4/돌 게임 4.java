import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            System.out.println((n % 7 == 1 || n % 7 == 3) ? "CY" : "SK");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}