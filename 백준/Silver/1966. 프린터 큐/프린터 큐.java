import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Queue<Item> queue;

    static class Item {
        private final boolean isTarget;
        private final int weight;

        public Item(boolean isTarget, int weight) {
            this.isTarget = isTarget;
            this.weight = weight;
        }

        public boolean isTarget() {
            return isTarget;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < size; i++) {
            initQueue();
            print();
        }
    }

    private static void initQueue() {
        queue = new LinkedList<>();
        String inputString = scanner.nextLine().trim();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, " ");
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int targetIndex = Integer.parseInt(stringTokenizer.nextToken());

        inputString = scanner.nextLine().trim();
        stringTokenizer = new StringTokenizer(inputString, " ");

        for (int i = 0; i < size; i++) {
            Item item = new Item(i == targetIndex, Integer.parseInt(stringTokenizer.nextToken()));
            queue.add(item);
        }
    }

    private static void print() {
        int count = 0;
        while (!queue.isEmpty()) {
            boolean isFirstWeight = true;
            Item item = queue.poll();
            for (Item value : queue) {
                if (item.getWeight() < value.getWeight()) {
                    isFirstWeight = false;
                    queue.add(item);
                    break;
                }
            }

            if (isFirstWeight) {
                if (item.isTarget()) {
                    System.out.println(count + 1);
                    break;
                }
                count++;
            }
        }
    }
}
