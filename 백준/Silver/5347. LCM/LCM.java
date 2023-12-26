import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i<size; i++) {
            String inputString = scanner.nextLine().trim();
            String[] variables = inputString.split(" ");
            long a = Integer.parseInt(variables[0]);
            long b = Integer.parseInt(variables[1]);
            System.out.println(lcm(a, b));
        }
    }

    private static long gcd(long a, long b) {
        long x = Math.max(a, b);
        long y = Math.min(a, b);
        while (y != 0) {
            long tmp = x % y;
            x = y;
            y = tmp;
        }

        return x;
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}