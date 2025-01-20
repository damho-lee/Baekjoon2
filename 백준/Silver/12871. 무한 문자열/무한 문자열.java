import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str1 = reader.readLine().trim();
            String str2 = reader.readLine().trim();
            int strLength1 = str1.length();
            int strLength2 = str2.length();
            int gcd = gcd(strLength1, strLength2);
            int lcm = (strLength1 * strLength2) / gcd;

            StringBuilder newStr1 = new StringBuilder();
            StringBuilder newStr2 = new StringBuilder();

            for (int i = 0; i < lcm / strLength1; i++) {
                newStr1.append(str1);
            }

            for (int i = 0; i < lcm / strLength2; i++) {
                newStr2.append(str2);
            }

            System.out.println(newStr1.toString().equals(newStr2.toString()) ? 1 : 0);
        } catch (IOException e) {
        }
    }

    private static int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        int z;

        while (y != 0) {
            z = x % y;
            x = y;
            y = z;
        }

        return x;
    }
}