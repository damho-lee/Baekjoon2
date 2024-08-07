import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> findDivisor(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    private static int sumOfList(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    private static void write(StringBuffer stringBuffer, int n, List<Integer> list) {
        stringBuffer.append(n).append(" = ").append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            stringBuffer.append(" + ").append(list.get(i));
        }
        stringBuffer.append("\n");
    }

    private static void write(StringBuffer stringBuffer, int n) {
        stringBuffer.append(n).append(" is NOT perfect.");
        stringBuffer.append("\n");
    }

    private static void run() {
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                int n = Integer.parseInt(reader.readLine().trim());
                if (n == -1) {
                    break;
                }

                List<Integer> divisors = findDivisor(n);
                if (sumOfList(divisors) == n) {
                    write(stringBuffer, n, divisors);
                } else {
                    write(stringBuffer, n);
                }

                divisors.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        run();
    }
}
