import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i=0; i<size; i++) {
            String str[] = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            pq.add(new int[]{start, end});
        }
        PriorityQueue<Integer> classroom = new PriorityQueue<>();

        while(!pq.isEmpty()) {
            int current[] = pq.poll();
            if(!classroom.isEmpty() && current[0] >= classroom.peek()) {
                classroom.poll();
            }
            classroom.add(current[1]);
        }
        System.out.println(classroom.size());
    }
}