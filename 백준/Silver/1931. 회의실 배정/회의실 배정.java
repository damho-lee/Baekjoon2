import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            List<Meeting> list = new ArrayList<>();
            String[] inputs;

            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);

                list.add(new Meeting(start, end));
            }

            System.out.println(Solution.calculate(list));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    private Solution() {
    }

    public static int calculate(List<Meeting> list) {
        List<Meeting> meetingList = new ArrayList<>(list);
        meetingList.sort((m1, m2) -> {
            if (m1.getEnd() == m2.getEnd()) {
                return m1.getStart() - m2.getStart();
            }

            return m1.getEnd() - m2.getEnd();
        });
        
        int count = 1;

        Meeting past = meetingList.get(0);
        Meeting current;
        for (int i = 1; i < meetingList.size(); i++) {
            current = meetingList.get(i);

            if (past.getEnd() <= current.getStart()) {
                past = current;
                count++;
            }
        }

        return count;
    }
}

class Meeting {
    private int start;
    private int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}