import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    private static List<Node>[] vertexes;
    private static int[] distance;
    private static int startVertex;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            int result = 1;

            for (int i = n; i > n - k; i--) {
                result *= i;
            }

            for (int i = k; i > 0; i--) {
                result /= i;
            }

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}