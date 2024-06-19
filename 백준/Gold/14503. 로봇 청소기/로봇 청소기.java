import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate());
    }
}

class Solution {
    private RobotVacuum robotVacuum;

    public Solution() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] room;
            room = new int[inputs[0]][inputs[1]];

            inputs = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = inputs[0];
            int y = inputs[1];
            int direction = inputs[2];

            for (int i = 0; i < room.length; i++) {
                room[i] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }


            robotVacuum = new RobotVacuum(new Point(x, y), direction, room);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int calculate() {
        return robotVacuum.run();
    }
}

class RobotVacuum {
    private Point currentLocation;
    private Direction direction;
    private int[][] room;
    private int[] dx = new int[]{1, 0, -1, 0};
    private int[] dy = new int[]{0, -1, 0, 1};
    private int count = 0;
    private static int cleanedRoom = 10;

    public RobotVacuum(Point currentLocation, int inputDirection, int[][] room) {
        this.currentLocation = currentLocation;
        this.direction = Direction.values()[inputDirection];
        this.room = room;
    }

    public int run() {
        while (true) {
            if (isUnCleaned()) {
                clean();
            }

            if (!hasUnCleanedBlank()) {
                if (canBack()) {
                    back();
                } else {
                    return terminate();
                }
            } else {
                rotateLeft();
                if (isFrontUnCleanedBlank()) {
                    go();
                }
            }
        }
    }

    private void clean() {
        this.room[currentLocation.getX()][currentLocation.getY()] = cleanedRoom++;
        count++;
    }

    private boolean isUnCleaned() {
        return this.room[currentLocation.getX()][currentLocation.getY()] == 0;
    }

    private boolean hasUnCleanedBlank() {
        for (int i = 0; i < 4; i++) {
            int newX = currentLocation.getX() + dx[i];
            int newY = currentLocation.getY() + dy[i];

            if (isValid(newX, newY) && room[newX][newY] == 0) {
                return true;
            }
        }

        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < room.length && y >= 0 && y < room[x].length;
    }

    private boolean canBack() {
        int x = currentLocation.getX() + dx[direction.ordinal()];
        int y = currentLocation.getY() + dy[direction.ordinal()];

        return isValid(x, y) && room[x][y] != 1;
    }

    private void back() {
        if (!canBack()) {
            throw new IllegalStateException("후진할 수 없습니다.");
        }

        this.currentLocation.move(dx[direction.ordinal()], dy[direction.ordinal()]);
    }

    private int terminate() {
        return this.count;
    }

    private void rotateLeft() {
        this.direction = Direction.values()[(this.direction.ordinal() + 3) % Direction.values().length];
    }

    private boolean isFrontUnCleanedBlank() {
        int x = currentLocation.getX() + dx[(direction.ordinal() + 2) % Direction.values().length];
        int y = currentLocation.getY() + dy[(direction.ordinal() + 2) % Direction.values().length];

        return isValid(x, y) && room[x][y] == 0;
    }

    private void go() {
        if (!isFrontUnCleanedBlank()) {
            throw new IllegalStateException("앞 칸이 청소되지 않은 칸이 아닙니다.");
        }
        this.currentLocation.move(dx[(direction.ordinal() + 2) % Direction.values().length], dy[(direction.ordinal() + 2) % Direction.values().length]);
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}

enum Direction {
    NORTH, EAST, SOUTH, WEST;
}