import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int[] input;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().trim());
            input = Stream.of(reader.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        }

        Arrays.sort(input);
        System.out.println(input[0] * input[n - 1]);
    }
}