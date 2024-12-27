import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split("-");
            String[] numbers;
            List<Integer> resultSet = new ArrayList<>();

            for (String input : inputs) {
                numbers = input.split("\\+");
                int result = 0;
                for (String number : numbers) {
                    result += Integer.parseInt(number);
                }

                resultSet.add(result);
            }

            int result = resultSet.get(0);
            for (int i = 1; i < resultSet.size();i ++) {
                result -= resultSet.get(i);
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
