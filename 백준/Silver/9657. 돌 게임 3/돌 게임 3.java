import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            
            String result = n % 7 == 0 || n % 7 == 2 ? "CY" : "SK";
            
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}