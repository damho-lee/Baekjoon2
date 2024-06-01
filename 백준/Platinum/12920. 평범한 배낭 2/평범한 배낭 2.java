import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Product> products;
    private static int m;

    private static void readInput() {
        products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(inputs[0].trim());
            m = Integer.parseInt(inputs[1].trim());

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().trim().split(" ");
                int weight = Integer.parseInt(inputs[0].trim());
                int satisfaction = Integer.parseInt(inputs[1].trim());
                int numberOfProduct = Integer.parseInt(inputs[2].trim());
                int count = 1;
                while (numberOfProduct > count) {
                    products.add(new Product(weight * count, satisfaction * count));
                    numberOfProduct -= count;
                    count *= 2;
                }

                if (numberOfProduct != 0) {
                    products.add(new Product(weight * numberOfProduct, satisfaction * numberOfProduct));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate() {
        int sizeOfList = products.size();
        int[][] array = new int[sizeOfList + 1][m + 1];

        for (int i = 1; i < array.length; i++) {
            Product current = products.get(i - 1);

            for (int j = 1; j < array[i].length; j++) {
                if (current.getWeight() <= j) {
                    array[i][j] = Math.max(array[i - 1][j - current.getWeight()] + current.getSatisfaction(), array[i - 1][j]);
                } else {
                    array[i][j] = array[i - 1][j];
                }
            }
        }

        return array[sizeOfList][m];
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
    private int satisfaction;

    public Product(int weight, int satisfaction) {
        this.weight = weight;
        this.satisfaction = satisfaction;
    }

    public int getWeight() {
        return weight;
    }

    public int getSatisfaction() {
        return satisfaction;
    }
}
