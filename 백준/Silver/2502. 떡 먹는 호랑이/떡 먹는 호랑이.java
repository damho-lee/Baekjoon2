import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int d = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            int[] dp = new int[31];
            dp[0] = 1;
            dp[1] = 1;
            int a = 1;
            int b;

            for (int i = 2; i <= 30; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            while (true) {
                int tmp = (k - dp[d - 3] * a);

                if (tmp % dp[d - 2] == 0) {
                    b = tmp / dp[d - 2];
                    break;
                }
                a++;
            }

            System.out.println(a);
            System.out.println(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
