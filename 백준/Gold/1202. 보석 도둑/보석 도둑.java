import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    private static Gem[] gems;
    private static int[] bags;

    public static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputStrings = reader.readLine().split(" ");
            int n = Integer.parseInt(inputStrings[0]);
            int k = Integer.parseInt(inputStrings[1]);
            gems = new Gem[n];
            bags = new int[k];

            for (int i = 0; i < n; i++) {
                inputStrings = reader.readLine().split(" ");
                int weight = Integer.parseInt(inputStrings[0]);
                int price = Integer.parseInt(inputStrings[1]);
                gems[i] = new Gem(weight, price);
            }

            for (int i = 0; i < k; i++) {
                bags[i] = Integer.parseInt(reader.readLine().trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long calculate() {
        Arrays.sort(gems);
        Arrays.sort(bags);
        long sumOfPrice = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < bags.length; i++) {
            while (j < gems.length && gems[j].getWeight() <= bags[i]) {
                priorityQueue.add(gems[j].getPrice());
                j++;
            }

            if (!priorityQueue.isEmpty()) {
                sumOfPrice += priorityQueue.poll();
            }
        }

        return sumOfPrice;
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}

class Gem implements Comparable {
    private int weight;
    private int price;

    public Gem(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.getWeight() + " " + this.getPrice();
    }

    @Override
    public int compareTo(Object o) {
        Gem other = (Gem) o;
        if (this.getWeight() == other.getWeight()) {
            return other.getPrice() - this.getPrice();
        }

        return this.getWeight() - other.getWeight();
    }
}