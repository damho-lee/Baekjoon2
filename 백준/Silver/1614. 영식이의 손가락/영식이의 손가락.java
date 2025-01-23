import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    private static final int THUMB = 1;
    private static final int INDEX_FINGER = 2;
    private static final int MIDDLE_FINGER = 3;
    private static final int RING_FINGER = 4;
    private static final int PINKY = 5;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long finger = Long.parseLong(reader.readLine().trim());
            long count = Long.parseLong(reader.readLine().trim());
            long result;

            if (finger == THUMB) {
                result = count * 8;
            } else if (finger == INDEX_FINGER) {
                result = 1 + (count / 2) * 8 + (count % 2) * 6;
            } else if (finger == MIDDLE_FINGER) {
                result = 2 + (count / 2) * 8 + (count % 2) * 4;
            } else if (finger == RING_FINGER) {
                result = 3 + (count / 2) * 8 + (count % 2) * 2;
            } else if (finger == PINKY) {
                result = 4 + count * 8;
            } else {
                throw new IllegalArgumentException("손가락 숫자 입력 오류");
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}