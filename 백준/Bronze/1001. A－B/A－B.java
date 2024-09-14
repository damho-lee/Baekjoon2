import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            System.out.println(Integer.parseInt(inputs[0]) - Integer.parseInt(inputs[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}