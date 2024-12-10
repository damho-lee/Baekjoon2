import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long n = Long.parseLong(reader.readLine().trim());

            System.out.println(playGame(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String playGame(long n) {
        return n % 7 == 0 || n % 7 == 2 ? "CY" : "SK";
    }
}