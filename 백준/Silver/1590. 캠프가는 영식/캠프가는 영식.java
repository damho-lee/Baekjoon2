import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int numberOfBuses = Integer.parseInt(inputs[0]);
            int arrivalTime = Integer.parseInt(inputs[1]);
            List<Bus> buses = new ArrayList<>();

            for (int i = 0; i < numberOfBuses; i++) {
                inputs = reader.readLine().split(" ");
                buses.add(new Bus(
                        Integer.parseInt(inputs[0]),
                        Integer.parseInt(inputs[1]),
                        Integer.parseInt(inputs[2])
                ));
            }

            System.out.println(calculate(buses, arrivalTime));
        } catch (IOException e) {
        }
    }

    private static int calculate(List<Bus> buses, int arrivalTime) {
        int result = Integer.MAX_VALUE;

        for (Bus bus : buses) {
            int time = bus.getStart();
            for (int i = 0; i < bus.getDailyRuns(); i++) {
                if (time >= arrivalTime) {
                    result = Math.min(result, time - arrivalTime);
                    break;
                }

                time += bus.getDispatchInterval();
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}

class Bus {
    private final int start;
    private final int dispatchInterval;
    private final int dailyRuns;

    public Bus(int start, int dispatchInterval, int dailyRuns) {
        this.start = start;
        this.dispatchInterval = dispatchInterval;
        this.dailyRuns = dailyRuns;
    }

    public int getStart() {
        return start;
    }

    public int getDispatchInterval() {
        return dispatchInterval;
    }

    public int getDailyRuns() {
        return dailyRuns;
    }
}