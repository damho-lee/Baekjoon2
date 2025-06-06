import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] inputs;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputs = reader.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        int r = Integer.parseInt(inputs[0]);
        int c = Integer.parseInt(inputs[1]);
        int w = Integer.parseInt(inputs[2]);
        int sum = 0;
        
        int[][] dp = new int[r + w + 1][r + w + 1];
        dp[1][1] = 1;

        for (int i = 2; i <= r + w; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                sum += dp[r + i][c + j];
            }
        }
        
        System.out.print(sum);
    }
}
