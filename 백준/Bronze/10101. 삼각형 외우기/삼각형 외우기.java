import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int side1;
        int side2;
        int side3;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            side1 = Integer.parseInt(reader.readLine().trim());
            side2 = Integer.parseInt(reader.readLine().trim());
            side3 = Integer.parseInt(reader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (side1 == 60 && side2 == 60 && side3 == 60) {
            System.out.println("Equilateral");
        } else if (side1 + side2 + side3 == 180) {
            if (side1 == side2 || side2 == side3 || side3 == side1) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        }
    }
}
