import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final boolean[] primeCheck = new boolean[2_000_000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x == 1) {
            System.out.println(2);
            return;
        }
        init();

        while (true) {
            if (!isPrime(x)) {
                x++;
                continue;
            }

            char[] numbers = String.valueOf(x).toCharArray();
            boolean isPalindrome = true;

            int center = numbers.length / 2;
            if (center % 2 == 1) {
                center++;
            }

            for (int i = 0; i < center; i++) {
                if (numbers[i] != numbers[(numbers.length - 1) - i]) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println(x);
                break;
            }

            x++;
        }
    }

    private static void init() {
        Arrays.fill(primeCheck, true);

        for (int i = 2; i < primeCheck.length; i++) {
            for (int j = 2; i * j < primeCheck.length; j++) {
                primeCheck[i * j] = false;
            }
        }
    }

    private static boolean isPrime(int x) {
        return primeCheck[x];
    }
}