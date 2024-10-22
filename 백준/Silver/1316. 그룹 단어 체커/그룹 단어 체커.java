import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < n; i++) {
                if (Solution.isGroupWord(reader.readLine().trim())) {
                    count++;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(count);
    }
}

class Solution {
    private Solution() {}

    public static boolean isGroupWord(String string) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < string.length(); i++) {
            if (i + 1 < string.length() && string.charAt(i) == string.charAt(i + 1)) {
                continue;
            }

            if (set.contains(string.charAt(i))) {
                return false;
            } else {
                set.add(string.charAt(i));
            }
        }

        return true;
    }
}