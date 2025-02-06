import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs;
            String input;

            while ((input = reader.readLine()) != null && !input.isEmpty()) {
                inputs = input.split(" ");
                int n = Integer.parseInt(inputs[0]);
                int m = Integer.parseInt(inputs[1]);
                int count = 0;

                for (int roomNumber = n; roomNumber <= m; roomNumber++) {
                    char[] numbers = String.valueOf(roomNumber).toCharArray();

                    if (isValid(numbers)) {
                        count++;
                    }
                }

                writer.write(count + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(char[] array) {
        boolean[] isDuplicated = new boolean[10];
        int number;

        for (char ch : array) {
            number = ch - '0';
            if (isDuplicated[number]) {
                return false;
            }

            isDuplicated[number] = true;
        }

        return true;
    }
}