import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String p;
    private static String inputs;
    private static int size;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            p = "";
            for (int i = 0; i < n; i++) {
                p += "IO";
            }
            p += "I";

            size = Integer.parseInt(reader.readLine().trim());
            inputs = reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int count = 0;
        boolean contain;
        for (int i = 0; i < size - p.length() + 1; i++) {
            contain = true;
            for (int j = 0; j < p.length(); j++) {
                if (inputs.charAt(i + j) != p.charAt(j)) {
                    contain = false;
                    break;
                }
            }

            if (contain) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}
