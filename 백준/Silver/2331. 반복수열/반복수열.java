import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int p = Integer.parseInt(inputs[1]);

            List<Integer> list = new ArrayList<>();
            list.add(a);
            int pastValue = a;
            int calculatedValue;

            while (true) {
                calculatedValue = calculate(pastValue, p);

                if (list.contains(calculatedValue)) {
                    System.out.println(list.indexOf(calculatedValue));
                    return;
                }

                list.add(calculatedValue);
                pastValue = calculatedValue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculate(int number, int exponent) {
        String[] numbers = String.valueOf(number).split("");

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).reduce(0, (total, n) -> (int) (total + Math.pow(n, exponent)));
    }
}