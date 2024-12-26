import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            
            double a = Double.parseDouble(inputs[0]);
            double b = Double.parseDouble(inputs[1]);
            
            System.out.println(a / b);
        } catch(IOException e) {
        }
    }
}