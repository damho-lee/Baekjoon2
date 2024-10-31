import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            List<Ingredient> ingredients = new ArrayList<>();

            String[] inputs;
            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                ingredients.add(new Ingredient(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
            }

            solution = new Solution(ingredients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private final List<Ingredient> ingredients;
    private int result;

    public Solution(List<Ingredient> ingredients) {
        this.ingredients = ingredients.subList(0, ingredients.size());
        init();
    }

    private void init() {
        this.result = Integer.MAX_VALUE;
    }

    public int solve() {
        init();

        calculate(0, 0, 1, 0);

        return this.result;
    }

    private void calculate(int current, int numberOfSelectedIngredient, int sourness, int bitterness) {
        if (current == this.ingredients.size()) {
            if (numberOfSelectedIngredient != 0) {
                this.result = Math.min(this.result, Math.abs(sourness - bitterness));
            }

            return;
        }

        calculate(current + 1, numberOfSelectedIngredient, sourness, bitterness);

        Ingredient currentIngredient = this.ingredients.get(current);
        calculate(current + 1,
                numberOfSelectedIngredient + 1,
                sourness * currentIngredient.getDegreeOfSourness(),
                bitterness + currentIngredient.getDegreeOfBitterness());
    }
}

class Ingredient {
    private int degreeOfSourness;
    private int degreeOfBitterness;

    public Ingredient(int degreeOfSourness, int degreeOfBitterness) {
        this.degreeOfSourness = degreeOfSourness;
        this.degreeOfBitterness = degreeOfBitterness;
    }

    public int getDegreeOfSourness() {
        return degreeOfSourness;
    }

    public int getDegreeOfBitterness() {
        return degreeOfBitterness;
    }
}