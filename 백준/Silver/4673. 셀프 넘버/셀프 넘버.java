import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            boolean[] isSelfNumber = new boolean[10001];
            Arrays.fill(isSelfNumber, true);

            for (int i = 1; i < isSelfNumber.length; i++) {
                int number = i;
                int sum = number;

                while (number > 0) {
                    sum += number % 10;
                    number /= 10;
                }

                if (sum < 10001) {
                    isSelfNumber[sum] = false;
                }
            }

            for (int i = 1; i < isSelfNumber.length; i++) {
                if (isSelfNumber[i]) {
                    writer.write(i + "\n");
                }
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}