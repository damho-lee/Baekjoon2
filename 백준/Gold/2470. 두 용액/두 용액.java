import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            String inputString = reader.readLine();
            String[] inputArray = inputString.split(" ");
            return Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Numbers calculate(int[] sortedArray) {
        if (sortedArray.length == 0 || sortedArray == null) {
            throw new IllegalArgumentException("크기가 0 이상인 오름차순 졍렬된 배열을 넣어주세요");
        }

        int start = 0;
        int end = sortedArray.length - 1;
        int min = Integer.MAX_VALUE;
        int sum;
        Numbers numbers = new Numbers(start, end);
        while (start < end) {
            sum = sortedArray[start] + sortedArray[end];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                numbers.setSmallNumber(sortedArray[start]);
                numbers.setLargeNumber(sortedArray[end]);
            }

            if (sum <= 0) {
                start++;
            } else {
                end--;
            }
        }

        return numbers;
    }

    public static void main(String[] args) {
        int[] inputs = readInput();
        Arrays.sort(inputs);
        Numbers numbers = calculate(inputs);
        System.out.println(numbers);
    }
}

class Numbers {
    private int smallNumber;
    private int largeNumber;

    public Numbers(int smallNumber, int largeNumber) {
        this.smallNumber = smallNumber;
        this.largeNumber = largeNumber;
    }

    public int getSmallNumber() {
        return smallNumber;
    }

    public int getLargeNumber() {
        return largeNumber;
    }

    public void setSmallNumber(int smallNumber) {
        this.smallNumber = smallNumber;
    }

    public void setLargeNumber(int largeNumber) {
        this.largeNumber = largeNumber;
    }

    @Override
    public String toString() {
        return getSmallNumber() + " " + getLargeNumber();
    }
}