import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Product> products;
    private static int n;
    private static int k;

    private static void readInput() {
        products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            n = Integer.parseInt(inputs[0].trim());
            k = Integer.parseInt(inputs[1].trim());

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().trim().split(" ");
                products.add(new Product(Integer.parseInt(inputs[0].trim()), Integer.parseInt(inputs[1].trim())));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int[][] array = new int[n + 1][k + 1];

        for (int i = 0; i < n + 1; i++) {
            array[i][0] = 0;
        }

        for (int i = 0; i < k + 1; i++) {
            array[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            Product current = products.get(i - 1);

            for (int j = 1; j < k + 1; j++) {
                if (current.getWeight() <= j) {
                    array[i][j] = Math.max(array[i - 1][j - current.getWeight()] + current.getValue(), array[i - 1][j]);
                } else {
                    array[i][j] = array[i - 1][j];
                }
            }
        }
        
        return array[n][k];
    }

    private static void run() {
        readInput();
        System.out.println(calculate());
    }

    public static void main(String[] args) {
        run();
    }
}

class Product {
    private int weight;
    private int value;

    public Product(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}