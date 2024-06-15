import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate());
    }
}

class Solution {
    private int[] inputs;
    private int amount;

    public Solution() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            this.inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            amount = Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String calculate() {
        List<Integer> digits = new ArrayList<>();
        int minimumValueIndex = findMinimumValueIndex(0, inputs.length);
        if (minimumValueIndex == 0) {
            minimumValueIndex = findMinimumValueIndex(1, inputs.length);
        }

        digits.add(minimumValueIndex);
        amount -= inputs[minimumValueIndex];

        minimumValueIndex = findMinimumValueIndex(0, inputs.length);

        while (amount - inputs[minimumValueIndex] >= 0) {
            digits.add(minimumValueIndex);
            amount -= inputs[minimumValueIndex];
        }

        int[] result = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            int maximumValueIndex = findMaximumValueIndexWithinAmount(digits.get(i));
            result[i] = maximumValueIndex;
            amount = amount + inputs[digits.get(i)] - inputs[maximumValueIndex];
        }

        return translate(result);
    }

    private int findMinimumValueIndex(int start, int end) {
        if (start < 0 || end > inputs.length) {
            throw new IllegalStateException("Solution::minIndex() : 범위가 올바르지 않습니다.");
        }

        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = start; i < end; i++) {
            if (min > inputs[i]) {
                min = inputs[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private int findMaximumValueIndexWithinAmount(int currentIndex) {
        int maxAmount = amount + inputs[currentIndex];
        int maximumValueIndex = currentIndex;

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] <= maxAmount) {
                maximumValueIndex = i;
            }
        }

        return maximumValueIndex;
    }

    private String translate(int[] array) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : array) {
            stringBuffer.append(i);
        }

        return stringBuffer.toString();
    }
}