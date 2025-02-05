import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            char d = inputs[1].charAt(0);
            int count = 0;

            for (int i = n; i > 0; i--) {
                char[] numbers = String.valueOf(i).toCharArray();
                for (char number : numbers) {
                    if (number == d) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        } catch (IOException e) {
        }
    }
}