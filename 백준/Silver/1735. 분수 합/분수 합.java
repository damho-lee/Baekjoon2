import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine().trim();
        String[] numbers = inputString.split(" ");
        Fraction firstFraction = new Fraction(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));

        inputString = scanner.nextLine().trim();
        numbers = inputString.split(" ");
        Fraction secondFraction = new Fraction(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));

        Fraction resultFraction = firstFraction.add(secondFraction);
        System.out.println(resultFraction.toString());
    }

    static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException();
            }
            this.numerator = numerator;
            this.denominator = denominator;
            normalize();
        }

        public Fraction add(Fraction fraction) {
            int lcm = lcm(this.denominator, fraction.denominator);

            return new Fraction(
                    (lcm / this.denominator) * this.numerator + (lcm / fraction.denominator) * fraction.numerator,
                    lcm);
        }

        private int gcd(int a, int b) {
            int x = Math.max(a, b);
            int y = Math.min(a, b);

            while (y != 0) {
                int tmp = x % y;
                x = y;
                y = tmp;
            }

            return x;
        }

        private int lcm(int a, int b) {
            return (a * b) / gcd(a, b);
        }

        private void normalize() {
            int gcd = gcd(this.numerator, this.denominator);
            this.numerator /= gcd;
            this.denominator /= gcd;
        }

        @Override
        public String toString() {
            return this.numerator + " " + this.denominator;
        }
    }
}
