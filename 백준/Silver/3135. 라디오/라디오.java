import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int target = Integer.parseInt(inputs[1]);
            int n = Integer.parseInt(reader.readLine());
            List<Integer> bookmarkList = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                bookmarkList.add(Integer.parseInt(reader.readLine().trim()));
            }

            for (Integer bookmark : bookmarkList) {
                if (Math.abs(start - target) > Math.abs(bookmark - target)) {
                    start = bookmark;
                    count = 1;
                }
            }

            System.out.println(Math.abs(start - target) + count);
        } catch (IOException e) {
        }
    }
}