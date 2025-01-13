import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> primes = new ArrayList<>();

            for (int i : inputs) {
                if (Prime.isPrime(i)) {
                    primes.add(i);
                }
            }

            System.out.println(Solution.calculate(primes));
        } catch (IOException e) {
        }
    }
}

class Solution {
    private Solution() {
    }

    public static long calculate(List<Integer> primes) {
        if (primes.isEmpty() || includeNotPrime(primes)) {
            return -1;
        }

        long result = primes.get(0);

        for (Integer n : primes) {
            result = lcm(result, n);
        }

        return result;
    }

    private static boolean includeNotPrime(List<Integer> primes) {
        for (Integer prime : primes) {
            if (!Prime.isPrime(prime)) {
                return true;
            }
        }

        return false;
    }

    private static long gcd(long a, long b) {
        long c = 0;

        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }

        return a;
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}

class Prime {
    private static boolean[] isPrime;
    private static final int arraySize = 1_000_000;

    private Prime() {
    }

    private static void init() {
        isPrime = new boolean[arraySize];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < arraySize; i++) {
            for (int j = 2; i * j < arraySize; j++) {
                isPrime[i * j] = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (isPrime == null) {
            init();
        }

        return isPrime[n];
    }
}