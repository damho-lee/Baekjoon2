import java.io.*;
import java.util.stream.Stream;

public class Main {
    private static final int MAN = 1;
    private static final int WOMAN = 2;
    private static final int ON = 1;
    private static final int OFF = 0;
    private static int[] switches;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            switches = new int[n + 1];
            String[] inputs = reader.readLine().split(" ");

            for (int i = 1; i < switches.length; i++) {
                switches[i] = Integer.parseInt(inputs[i - 1]);
            }

            n = Integer.parseInt(reader.readLine().trim());
            int gender;
            int number;

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                gender = Integer.parseInt(inputs[0]);
                number = Integer.parseInt(inputs[1]);

                handleGenderCase(gender, number);
            }

            System.out.println(generateResult());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleGenderCase(int gender, int number) {
        if (gender == MAN) {
            caseOfMan(number);
        } else {
            caseOfWoman(number);
        }
    }

    private static void caseOfMan(int number) {
        for (int i = 1; number * i < switches.length; i++) {
            toggleSwitch(number * i);
        }
    }

    private static void caseOfWoman(int number) {
        int start = number - 1;
        int end = number + 1;

        while (start >= 1 && end < switches.length) {
            if (switches[start] != switches[end]) {
                break;
            }

            start--;
            end++;
        }

        for (int i = start + 1; i < end; i++) {
            toggleSwitch(i);
        }
    }

    private static void toggleSwitch(int number) {
        switches[number] = switches[number] == ON ? OFF : ON;
    }

    private static String generateResult() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(switches[1] + " ");

        for (int i = 2; i < switches.length; i++) {
            stringBuffer.append(switches[i]).append(" ");

            if (i % 20 == 0) {
                stringBuffer.append("\n");
            }
        }

        return stringBuffer.toString();
    }
}