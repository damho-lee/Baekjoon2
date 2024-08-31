import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            List<String> nList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                nList.add(reader.readLine().trim());
            }
            nList.sort(String::compareTo);

            String input;
            int count = 0;
            for (int i = 0; i < m; i++) {
                input = reader.readLine().trim();
                int l = 0;
                int r = n - 1;
                String current;

                while (l <= r) {
                    int mid = (l + r) / 2;
                    current = nList.get(mid);
                    if (input.compareTo(current) > 0) {
                        l = mid + 1;
                    } else if (input.compareTo(current) < 0) {
                        r = mid - 1;
                    } else {
                        count++;
                        break;
                    }
                }
            }

            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}