import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static final int EAST = 1;
    private static final int WEST = 2;
    private static final int SOUTH = 3;
    private static final int NORTH = 4;
    private static int[] sides;
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfOrientalMelon = Integer.parseInt(reader.readLine().trim());
            sides = new int[6];
            int maxHeight = Integer.MIN_VALUE;
            int maxWidth = Integer.MIN_VALUE;
            int maxHeightIndex = 0;
            int maxWidthIndex = 0;
            String[] inputs;

            for (int i = 0; i < 6; i++) {
                inputs = reader.readLine().split(" ");
                int direction = Integer.parseInt(inputs[0]);
                int length = Integer.parseInt(inputs[1]);
                sides[i] = length;

                if ((direction == EAST || direction == WEST) && length > maxWidth) {
                    maxWidth = length;
                    maxWidthIndex = i;
                } else if ((direction == SOUTH || direction == NORTH) && length > maxHeight) {
                    maxHeight = length;
                    maxHeightIndex = i;
                }
            }

            System.out.println((maxHeight * maxWidth - calculateSide(maxHeightIndex) * calculateSide(maxWidthIndex)) * numberOfOrientalMelon);
        } catch (IOException e) {
        }
    }

    private static int calculateSide(int index) {
        int leftIndex = ((index - 1) + sides.length) % sides.length;
        int rightIndex = ((index + 1)) % sides.length;

        return Math.abs(sides[leftIndex] - sides[rightIndex]);
    }
}