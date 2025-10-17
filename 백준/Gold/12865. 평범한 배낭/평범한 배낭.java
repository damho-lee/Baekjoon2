import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ProductRepository repository = new ConsoleProductRepository();
            KnapsackSolver solver = new KnapsackSolverWithOneDimensionalArrangement();

            ProblemInput input = repository.readInput();
            int result = solver.solve(input);

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException("입력 처리 중 오류가 발생했습니다.", e);
        }
    }
}

class Product {
    private final int weight;
    private final int value;

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

class ProblemInput {
    private final List<Product> products;
    private final int maxWeight;

    public ProblemInput(List<Product> products, int maxWeight) {
        this.products = products;
        this.maxWeight = maxWeight;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}

interface ProductRepository {
    ProblemInput readInput() throws IOException;
}

class ConsoleProductRepository implements ProductRepository {

    @Override
    public ProblemInput readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int numberOfProducts = Integer.parseInt(firstLine[0]);
        int maxWeight = Integer.parseInt(firstLine[1]);

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < numberOfProducts; i++) {
            String[] line = reader.readLine().split(" ");
            int weight = Integer.parseInt(line[0]);
            int value = Integer.parseInt(line[1]);
            products.add(new Product(weight, value));
        }

        return new ProblemInput(products, maxWeight);
    }
}

interface KnapsackSolver {
    int solve(ProblemInput input);
}

class KnapsackSolverWithOneDimensionalArrangement implements KnapsackSolver {

    @Override
    public int solve(ProblemInput input) {
        List<Product> products = input.getProducts();
        int numberOfProducts = products.size();
        int maxWeight = input.getMaxWeight();
        int[] dp = new int[maxWeight + 1];

        for (Product product : products) {
            int weight = product.getWeight();
            int value = product.getValue();

            for (int w = maxWeight; w >= weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }

        return dp[maxWeight];
    }
}

class KnapsackSolverWithTwoDimensionalArrangement implements KnapsackSolver {

    @Override
    public int solve(ProblemInput input) {
        List<Product> products = input.getProducts();
        int numberOfProducts = products.size();
        int maxWeight = input.getMaxWeight();

        int[][] dp = new int[numberOfProducts][maxWeight + 1];

        Product firstProduct = products.get(0);
        for (int w = firstProduct.getWeight(); w <= maxWeight; w++) {
            dp[0][w] = firstProduct.getValue();
        }

        for (int i = 1; i < numberOfProducts; i++) {
            Product current = products.get(i);

            for (int j = 0; j <= maxWeight; j++) {
                dp[i][j] = j < current.getWeight() ? dp[i - 1][j] : Math.max(dp[i - 1][j], dp[i - 1][j - current.getWeight()] + current.getValue());
            }
        }

        return dp[numberOfProducts - 1][maxWeight];
    }
}