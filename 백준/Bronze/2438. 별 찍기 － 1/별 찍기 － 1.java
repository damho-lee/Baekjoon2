import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            System.out.println(printStars(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String printStars(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                stringBuilder.append("*");
            }

            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}