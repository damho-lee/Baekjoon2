import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            Book[] books = new Book[m + 1];

            for (int i = 1; i <= m; i++) {
                inputs = reader.readLine().split(" ");
                books[i] = new Book(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
            }

            System.out.println(Solution.solve(n, books));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    public static int solve(int day, Book[] books) {
        int m = books.length - 1;
        int[][] dp = new int[m + 1][day + 1];

        for (int i = 1; i <= m; i++) {
            int bookDays = books[i].getNumberOfDay();
            int bookPages = books[i].getNumberOfPage();

            for (int j = 1; j <= day; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= bookDays) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - bookDays] + bookPages);
                }
            }
        }

        return dp[m][day];
    }
}


class Book {
    private final int numberOfDay;
    private final int numberOfPage;

    public Book(int numberOfDay, int numberOfPages) {
        this.numberOfDay = numberOfDay;
        this.numberOfPage = numberOfPages;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }
}