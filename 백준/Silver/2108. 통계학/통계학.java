import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> list;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(reader.readLine().trim()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculateAverage() {
        double result = 0;
        for (Integer i : list) {
            result += i;
        }

        result /= list.size();

        return (int) Math.round(result);
    }

    private static int calculateCenterValue() {
        return list.get(list.size() / 2);
    }

    private static int calculateMode() {
        int[] count = new int[8001];
        List<Integer> tmp = new ArrayList<>();

        for (Integer i : list) {
            count[i + 4000]++;
        }

        int maxCount = 0;
        int sameCount = 0;

        for (int i : count) {
            maxCount = Math.max(maxCount, i);
        }

        for (int i = 0; i < count.length; i++) {
            if (maxCount == count[i]) {
                sameCount++;
                tmp.add(i - 4000);
            }
        }

        tmp.sort(Integer::compareTo);

        if (sameCount == 1) {
            return tmp.get(0);
        } else {
            return tmp.get(1);
        }
    }

    private static int calculateRange() {
        return list.get(list.size() - 1) - list.get(0);
    }

    private static String run() {
        readInput();
        list.sort(Integer::compareTo);

        StringBuffer buffer = new StringBuffer();
        buffer.append(calculateAverage() + "\n");
        buffer.append(calculateCenterValue() + "\n");
        buffer.append(calculateMode() + "\n");
        buffer.append(calculateRange());

        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(run());
    }
}
