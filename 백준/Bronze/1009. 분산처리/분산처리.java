import java.io.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] inputs;
            int a;
            int b;
            int total;

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                a = Integer.parseInt(inputs[0]);
                b = Integer.parseInt(inputs[1]);
                total = 1;

                for (int ii = 0; ii < b; ii++) {
                    total = (total * a) % 10;
                }

                if (total == 0) {
                    total = 10;
                }

                writer.write(total + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
