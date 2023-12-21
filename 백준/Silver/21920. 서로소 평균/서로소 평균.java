import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine().trim());
        int count = 0;
        double sum = 0;
        int[] arr = new int[size];

        String inputString = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, " ");

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int target = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < size; i++) {
            if (isCoprime(target, arr[i])) {
                sum += arr[i];
                count++;
            }
        }

        System.out.println(sum / count);
    }

    private static boolean isCoprime(int x, int y) {
        int a = Math.max(x, y);
        int b = Math.min(x, y);

        while (b != 0) {
            int n = a%b;
            a = b;
            b = n;
        }

        return a == 1;
    }
}
