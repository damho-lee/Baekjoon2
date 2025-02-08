import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            int sum = sum(k);
            n -= sum;
            int result;

            if (n < 0) {
                result = -1;
            } else {
                if (n % k == 0) {
                    result = k - 1;
                } else {
                    result = k;
                }
            }

            writer.write(result + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int sum(int n) {
        return n * (n + 1) / 2;
    }
}