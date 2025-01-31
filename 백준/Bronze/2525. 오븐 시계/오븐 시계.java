import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int hour = Integer.parseInt(inputs[0]);
            int minute = Integer.parseInt(inputs[1]);
            int plus = Integer.parseInt(reader.readLine().trim());

            minute += plus;
            hour += minute / 60;
            minute %= 60;
            hour %= 24;

            System.out.println(hour + " " + minute);
        } catch (IOException e) {
        }
    }
}