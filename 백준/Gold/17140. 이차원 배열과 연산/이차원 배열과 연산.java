import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    private static int r;
    private static int c;
    private static int k;
    private static int rowLength = 3;
    private static int columnLength = 3;
    private static int[][] values = new int[101][101];

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            r = Integer.parseInt(inputs[0]);
            c = Integer.parseInt(inputs[1]);
            k = Integer.parseInt(inputs[2]);
            for (int i = 1; i <= rowLength; i++) {
                inputs = reader.readLine().trim().split(" ");
                values[i][1] = Integer.parseInt(inputs[0]);
                values[i][2] = Integer.parseInt(inputs[1]);
                values[i][3] = Integer.parseInt(inputs[2]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        for (int i = 0; i <= 100; i++) {
            if (values[r][c] == k) {
                return i;
            }

            if (rowLength >= columnLength) {
                operationR();
            } else {
                operationC();
            }
        }

        return -1;
    }

    private static void operationR() {
        for (int i = 1; i <= rowLength; i++) {
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 1; j <= columnLength; j++) {
                if (values[i][j] == 0) {
                    continue;
                }

                if (!map.containsKey(values[i][j])) {
                    map.put(values[i][j], 1);
                } else {
                    int count = map.get(values[i][j]);
                    map.put(values[i][j], count + 1);
                }
            }

            map.forEach((number, count) -> priorityQueue.add(new Pair(number, count)));
            int j = 0;
            while (!priorityQueue.isEmpty()) {
                Pair pair = priorityQueue.poll();
                values[i][++j] = pair.getNumber();
                values[i][++j] = pair.getCount();
            }

            columnLength = Math.max(columnLength, j);

            while (j < 100) {
                values[i][++j] = 0;
            }
        }
    }

    private static void operationC() {
        for (int i = 1; i <= columnLength; i++) {
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 1; j <= rowLength; j++) {
                if (values[j][i] == 0) {
                    continue;
                }

                if (!map.containsKey(values[j][i])) {
                    map.put(values[j][i], 1);
                } else {
                    int count = map.get(values[j][i]);
                    map.put(values[j][i], count + 1);
                }
            }

            map.forEach((number, count) -> priorityQueue.add(new Pair(number, count)));

            int j = 0;

            while (!priorityQueue.isEmpty()) {
                Pair pair = priorityQueue.poll();
                values[++j][i] = pair.getNumber();
                values[++j][i] = pair.getCount();
            }

            rowLength = Math.max(rowLength, j);

            while (j < 100) {
                values[++j][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}

class Pair implements Comparable {
    private int number;
    private int count;

    public Pair(int number, int count) {
        this.number = number;
        this.count = count;
    }

    public int getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(Object o) {
        Pair other = (Pair) o;
        if (this.count == other.count) {
            return this.getNumber() - other.getNumber();
        } else {
            return this.getCount() - other.getCount();
        }
    }
}