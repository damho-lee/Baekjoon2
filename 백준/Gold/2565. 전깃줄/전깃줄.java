import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            Wire[] wires = new Wire[n];
            String[] inputs;

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                wires[i] = new Wire(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
            }

            System.out.println(calculate(wires));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(Wire[] inputs) {
        Wire[] wires = inputs.clone();
        Arrays.sort(wires, Comparator.comparingInt(Wire::getX));
        int[] array = Arrays.stream(wires).mapToInt(Wire::getY).toArray();

        return array.length - calculateLIS(array);
    }

    private static int calculateLIS(int[] array) {
        int[] lis = new int[array.length];
        lis[0] = array[0];
        int index = 1;

        for (int i = 1; i < array.length; i++) {
            if (lis[index - 1] < array[i]) {
                lis[index++] = array[i];
            } else {
                int tmp = binarySearch(lis, 0, index - 1, array[i]);
                lis[tmp] = array[i];
            }
        }

        return index;
    }

    private static int binarySearch(int[] array, int start, int end, int element) {
        int left = start;
        int right = end;

        while (left < right) {
            int mid = (left + right) / 2;
            if (element > array[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}

class Wire {
    private final int x;
    private final int y;

    public Wire(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}