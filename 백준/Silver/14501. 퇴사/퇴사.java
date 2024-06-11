import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Advice[] readInput() {
        Advice[] advices;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            advices = new Advice[n];
            for (int i = 0; i < n; i++) {
                String inputs[] = reader.readLine().trim().split(" ");
                int time = Integer.parseInt(inputs[0]);
                int price = Integer.parseInt(inputs[1]);
                advices[i] = new Advice(time, price);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return advices;
    }

    private static int calculate(Advice[] advices) {
        int[] array = new int[advices.length + 1];

        for (int i = 0; i < advices.length; i++) {
            Advice current = advices[i];
            if (i + current.getTime() <= advices.length) {
                array[i + current.getTime()] = Math.max(array[i + current.getTime()], array[i] + current.getPrice());
            }

            array[i + 1] = Math.max(array[i + 1], array[i]);
        }

        return array[advices.length];
    }

    private static void run() {
        Advice[] advices = readInput();
        System.out.println(calculate(advices));
    }

    public static void main(String[] args) {
        run();
    }
}

class Advice {
    private int time;
    private int price;

    public Advice(int time, int price) {
        this.time = time;
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.getTime() + " " + this.getPrice();
    }
}