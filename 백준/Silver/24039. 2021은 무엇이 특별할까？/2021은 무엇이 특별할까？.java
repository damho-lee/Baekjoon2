import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            System.out.println(Solution.calculate(n));
        } catch (IOException e) {
        }
    }
}

class Solution {
    private static List<Integer> primes;
    private static final int arraySize = 110;

    private Solution() {
    }

    private static void init() {
        boolean[] isPrime = new boolean[arraySize];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < arraySize; i++) {
            for (int j = 2; i * j < arraySize; j++) {
                isPrime[i * j] = false;
            }
        }

        primes = IntStream.range(2, arraySize)
                .filter(i -> isPrime[i])
                .boxed()
                .collect(Collectors.toList());
    }

    public static int calculate(int n) {
        if (primes == null) {
            init();
        }

        int specialNumber = -1;

        for (int i = 0; i < primes.size() - 1; i++) {
            if (primes.get(i) * primes.get(i + 1) > n) {
                specialNumber = primes.get(i) * primes.get(i + 1);
                break;
            }
        }

        return specialNumber;
    }
}