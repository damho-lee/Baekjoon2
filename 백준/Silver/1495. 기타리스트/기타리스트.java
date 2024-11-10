import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int s = Integer.parseInt(inputs[1]);
            int m = Integer.parseInt(inputs[2]);

            int[] volumes = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(Solution.calculate(s, m, volumes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    public static int calculate(int startVolume, int maxVolume, int[] inputVolumes) {
        int[] volumes = inputVolumes.clone();

        boolean[] current = new boolean[maxVolume + 1];
        current[startVolume] = true;

        for (int i = 0; i < volumes.length; i++) {
            int volumeDelta = volumes[i];
            boolean[] next = new boolean[maxVolume + 1];

            for (int j = 0; j <= maxVolume; j++) {
                if (current[j]) {
                    if (j + volumeDelta <= maxVolume) {
                        next[j + volumeDelta] = true;
                    }

                    if (j - volumeDelta >= 0) {
                        next[j - volumeDelta] = true;
                    }
                }
            }

            current = next;
        }

        int result = -1;

        for (int i = maxVolume; i >= 0; i--) {
            if (current[i]) {
                result = i;
                break;
            }
        }

        return result;
    }
}