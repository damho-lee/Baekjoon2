import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.run());
    }
}

class Solution {
    private Gear[] gears;
    private RotationMethod[] rotationMethods;

    public Solution() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            gears = new Gear[5];

            for (int i = 1; i < gears.length; i++) {
                int[] inputs = Stream.of(reader.readLine().trim().split("")).mapToInt(Integer::parseInt).toArray();
                gears[i] = new Gear(inputs);
            }

            int sizeOfRotationMethod = Integer.parseInt(reader.readLine());
            rotationMethods = new RotationMethod[sizeOfRotationMethod];

            for (int i = 0; i < rotationMethods.length; i++) {
                int[] inputs = Stream.of(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                rotationMethods[i] = new RotationMethod(inputs[0], inputs[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int run() {
        for (RotationMethod rotationMethod : rotationMethods) {
            rotate(rotationMethod.getGearNumber(), rotationMethod.getDirectionOfRotation());
        }

        return calculate();
    }

    private void rotate(int gearNumber, int directionOfRotation) {
        if (gearNumber - 1 > 0 && this.gears[gearNumber - 1].getRightPole() != this.gears[gearNumber].getLeftPole()) {
            rotateLeftGear(gearNumber - 1, directionOfRotation * -1);
        }

        if (gearNumber + 1 < gears.length && this.gears[gearNumber + 1].getLeftPole() != this.gears[gearNumber].getRightPole()) {
            rotateRightGear(gearNumber + 1, directionOfRotation * -1);
        }

        if (directionOfRotation == 1) {
            this.gears[gearNumber].rotateRight();
        } else {
            this.gears[gearNumber].rotateLeft();
        }
    }

    private void rotateLeftGear(int gearNumber, int directionOfRotation) {
        if (gearNumber <= 0) {
            return;
        }

        if (gearNumber - 1 > 0 && this.gears[gearNumber - 1].getRightPole() != this.gears[gearNumber].getLeftPole()) {
            rotateLeftGear(gearNumber - 1, directionOfRotation * -1);
        }

        if (directionOfRotation == 1) {
            this.gears[gearNumber].rotateRight();
        } else {
            this.gears[gearNumber].rotateLeft();
        }
    }

    private void rotateRightGear(int gearNumber, int directionOfRotation) {
        if (gearNumber >= gears.length) {
            return;
        }

        if (gearNumber + 1 < gears.length && this.gears[gearNumber + 1].getLeftPole() != this.gears[gearNumber].getRightPole()) {
            rotateRightGear(gearNumber + 1, directionOfRotation * -1);
        }

        if (directionOfRotation == 1) {
            this.gears[gearNumber].rotateRight();
        } else {
            this.gears[gearNumber].rotateLeft();
        }
    }

    private int calculate() {
        int sum = 0;
        int j = 1;

        for (int i = 1; i < gears.length; i++, j = j * 2) {
            if (gears[i].getTwelveOClockPole() == 1) {
                sum += j;
            }
        }

        return sum;
    }
}

class Gear {
    private int[] cogs;
    private int left;
    private int right;

    public Gear(int[] cogs) {
        this.cogs = cogs;
        this.left = 6;
        this.right = 2;
    }

    public void rotateRight() {
        this.right = ((this.right - 1) + cogs.length) % cogs.length;
        this.left = ((this.left - 1) + cogs.length) % cogs.length;
    }

    public void rotateLeft() {
        this.right = (this.right + 1) % cogs.length;
        this.left = (this.left + 1) % cogs.length;
    }

    public int getRightPole() {
        return this.cogs[this.right];
    }

    public int getLeftPole() {
        return this.cogs[this.left];
    }

    public int getTwelveOClockPole() {
        return this.cogs[((this.right - 2) + cogs.length) % cogs.length];
    }
}

class RotationMethod {
    private int gearNumber;
    private int directionOfRotation;

    public RotationMethod(int gearNumber, int directionOfRotation) {
        this.gearNumber = gearNumber;
        this.directionOfRotation = directionOfRotation;
    }

    public int getGearNumber() {
        return gearNumber;
    }

    public int getDirectionOfRotation() {
        return directionOfRotation;
    }
}