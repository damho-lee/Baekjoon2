import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for(int i=0; i<size; i++) {
            String[] str = br.readLine().split(" ");
            pq.add(new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])});
        }
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            if(!rooms.isEmpty() && current[0] >= rooms.peek()) {
                rooms.poll();
            }
            rooms.add(current[1]);
        }
        System.out.println(rooms.size());
    }
}