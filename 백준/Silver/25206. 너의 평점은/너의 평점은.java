import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double sum = 0;
            int sumOfCredit = 0;

            for (int i = 0; i < 20; i++) {
                String[] inputs = reader.readLine().split(" ");
                double grade = 0;
                String gradeInput = inputs[2];
                if (gradeInput.equals("A+")) {
                    grade = 4.5;
                } else if (gradeInput.equals("A0")) {
                    grade = 4.0;
                } else if (gradeInput.equals("B+")) {
                    grade = 3.5;
                } else if (gradeInput.equals("B0")) {
                    grade = 3.0;
                } else if (gradeInput.equals("C+")) {
                    grade = 2.5;
                } else if (gradeInput.equals("C0")) {
                    grade = 2.0;
                } else if (gradeInput.equals("D+")) {
                    grade = 1.5;
                } else if (gradeInput.equals("D0")) {
                    grade = 1.0;
                } else if (gradeInput.equals("F")) {
                    grade = 0;
                } else if (gradeInput.equals("P")) {
                    continue;
                } else {
                    throw new IllegalStateException("학점이 이상합니다.");
                }

                double credit = Double.parseDouble(inputs[1]);
                sum += credit * grade;
                sumOfCredit += credit;
            }

            System.out.println(sum / sumOfCredit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
