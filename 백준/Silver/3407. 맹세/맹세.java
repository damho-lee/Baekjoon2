import java.io.*;
import java.util.*;

public class Main {
    private static final String[] ELEMENTS = {
            "h", "b", "c", "n", "o", "f", "p", "s", "k", "v", "y", "i", "w", "u",
            "ba", "ca", "ga", "la", "na", "pa", "ra", "ta", "db", "nb", "pb", "rb", "sb", "tb", "yb", "ac",
            "sc", "tc", "cd", "gd", "md", "nd", "pd", "be", "ce", "fe", "ge", "he", "ne", "re", "se", "te",
            "xe", "cf", "hf", "rf", "ag", "hg", "mg", "rg", "sg", "bh", "rh", "th", "bi", "li", "ni", "si",
            "ti", "bk", "al", "cl", "fl", "tl", "am", "cm", "fm", "pm", "sm", "tm", "cn", "in", "mn", "rn",
            "sn", "zn", "co", "ho", "mo", "no", "po", "np", "ar", "br", "cr", "er", "fr", "ir", "kr", "lr",
            "pr", "sr", "zr", "as", "cs", "ds", "es", "hs", "os", "at", "mt", "pt", "au", "cu", "eu", "lu",
            "pu", "ru", "lv", "dy"
    };

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                String word = reader.readLine().trim();
                writer.write(isValid(word) ? "YES\n" : "NO\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(String word) {
        int length = word.length();
        boolean[] visited = new boolean[length + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int pos = queue.poll();

            if (pos == length) {
                return true;
            }

            for (String element : ELEMENTS) {
                int nextPos = pos + element.length();
                if (nextPos <= length && !visited[nextPos] && word.startsWith(element, pos)) {
                    visited[nextPos] = true;
                    queue.add(nextPos);
                }
            }
        }

        return false;
    }
}
