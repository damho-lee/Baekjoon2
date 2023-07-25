import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class date {
        int start;
        int end;
        public date(int start, int end) {
            this.start = start;
            this. end = end;
        }
    }

    static int start_idx = 0;
    static int sum = 0;
    static List<Integer> list = new ArrayList<>();
    static boolean flag = false;
    public static int getSum() {
        return sum+=(Collections.max(list) - start_idx + 1) * list.size();
    }
    public static void cal(PriorityQueue<date> pq) {
        while(!pq.isEmpty()) {
            date d = pq.poll();
            if(!list.isEmpty() && Collections.max(list) + 1 < d.start) {
                getSum();
                list.clear();
            }
            if(list.size() == 0) {
                start_idx = d.start;
                list.add(d.end);
                continue;
            }
            for(int j =0; j<list.size(); j++) {
                if(list.get(j) < d.start) {
                    list.set(j, d.end);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                list.add(d.end);
            }
            flag = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<date> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.start == e2.start)
                return e2.end - e1.end;
            return e1.start - e2.start;
        });
        for(int i=0;i< size; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");
            pq.add(new date(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        cal(pq);
        getSum();
        System.out.println(sum);
    }
}