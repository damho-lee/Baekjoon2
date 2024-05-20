import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(reader.readLine().trim());
            }

            return array;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int[] stairs) {
        if (stairs.length == 1) {
            return stairs[0];
        } else if (stairs.length == 2) {
            return stairs[0] + stairs[1];
        } else if (stairs.length == 3) {
            return Math.max(stairs[0], stairs[1]) + stairs[2];
        }

        int[] score = new int[stairs.length];

        score[0] = stairs[0];
        score[1] = stairs[0] + stairs[1];
        score[2] = Math.max(stairs[0], stairs[1]) + stairs[2];

        for (int i = 3; i < stairs.length; i++) {
            score[i] = Math.max(score[i - 3] + stairs[i - 1], score[i - 2]) + stairs[i];
        }

        return score[score.length - 1];
    }

    public static void main(String[] args) {
        int[] stairs = readInput();
        System.out.println(calculate(stairs));
    }
}
