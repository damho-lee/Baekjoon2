import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs;
            int i = 1;

            while (true) {
                inputs = reader.readLine().split(" ");
                int l = Integer.parseInt(inputs[0]);
                int p = Integer.parseInt(inputs[1]);
                int v = Integer.parseInt(inputs[2]);

                if (isEnd(l, p, v)) {
                    break;
                }

                writer.write(String.format("Case %d: %d%n", i++, calculate(l, p, v)));
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isEnd(int l, int p, int v) {
        return l == 0 && p == 0 && v == 0;
    }

    private static int calculate(int l, int p, int v) {
        return l * (v / p) + Math.min(l, v % p);
    }
}