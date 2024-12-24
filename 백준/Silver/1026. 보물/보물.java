import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            String[] input = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                list1.add(Integer.parseInt(input[i]));
            }

            input = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                list2.add(Integer.parseInt(input[i]));
            }

            list1.sort(Integer::compareTo);
            list2.sort((x, y) -> y - x);

            int result = 0;
            for (int i = 0; i < n; i++) {
                result += list1.get(i) * list2.get(i);
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
