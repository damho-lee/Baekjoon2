import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean isValid(int x, int y, int z) {
        int max = Math.max(Math.max(x, y), z);
        int min = Math.min(Math.min(x, y), z);
        int middle = x + y + z - max - min;

        return max < middle + min;
    }

    private static boolean isEquilateral(int x, int y, int z) {
        return x == y && y == z;
    }

    private static boolean isScalene(int x, int y, int z) {
        return (x == y && y != z) || (y == z && z != x) || (z == x && x != y);
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            stringBuffer = new StringBuffer();
            String[] inputs;
            int x;
            int y;
            int z;

            while (true) {
                inputs = reader.readLine().split(" ");
                x = Integer.parseInt(inputs[0]);
                y = Integer.parseInt(inputs[1]);
                z = Integer.parseInt(inputs[2]);

                if (x == 0 && y == 0 && z == 0) {
                    break;
                }

                if (isValid(x, y, z)) {
                    if (isEquilateral(x, y, z)) {
                        stringBuffer.append("Equilateral");
                    } else if (isScalene(x, y, z)) {
                        stringBuffer.append("Isosceles");
                    } else {
                        stringBuffer.append("Scalene");
                    }
                } else {
                    stringBuffer.append("Invalid");
                }
                stringBuffer.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(stringBuffer);
    }
}
