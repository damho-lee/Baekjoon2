import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int total = Integer.parseInt(reader.readLine().trim());
            int n = Integer.parseInt(reader.readLine().trim());
            int sum = 0;
            String[] inputs;
            
            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                int price = Integer.parseInt(inputs[0]);
                int amount = Integer.parseInt(inputs[1]);
                sum += price * amount;
            }
            
            String result = total == sum ? "Yes" : "No";
            System.out.println(result);
        } catch (IOException e) {
        }
    }
}