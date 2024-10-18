import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int[] array = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            solution = new Solution(m, array);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(solution.solve());
    }
}

class Solution {
    private final int lengthOfSequence;
    private final int[] input;
    private final int[] array;
    private final boolean[] visited;
    private final Set<String> set;


    public Solution(int lengthOfSequence, int[] array) {
        this.lengthOfSequence = lengthOfSequence;

        int[] tmp = array.clone();
        Arrays.sort(tmp);
        this.input = tmp;

        this.array = new int[lengthOfSequence];
        this.visited = new boolean[input.length];
        this.set = new TreeSet<>(
                (a, b) -> {
                    String[] aSplit = a.split(" ");
                    String[] bSplit = b.split(" ");

                    for (int i = 0; i < aSplit.length; i++) {
                        int aNum = Integer.parseInt(aSplit[i]);
                        int bNum = Integer.parseInt(bSplit[i]);
                        if (aNum != bNum) {
                            return aNum - bNum;
                        }
                    }

                    return 0;
                });
    }

    public String solve() {
        dfs(0);

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : set) {
            stringBuilder.append(string).append("\n");
        }

        return stringBuilder.toString();
    }

    private void dfs(int currentIndex) {
        if (currentIndex == this.lengthOfSequence) {
            set.add(IntStream.of(array)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));

            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[currentIndex] = input[i];
                dfs(currentIndex + 1);
                visited[i] = false;
            }
        }
    }
}