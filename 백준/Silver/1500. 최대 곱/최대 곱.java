import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            List<Long> list = new ArrayList<>();

            while (k > 0) {
                long tmp = s / k;
                list.add(tmp);
                s -= tmp;
                k--;
            }

            System.out.println(list.stream().reduce(1L, (x, y) -> x * y));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
