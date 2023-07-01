import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class queue {
    private int top = -1;
    private int queue[];
    private int size;
    private int k;
    public queue(int size, int k) {
        queue = new int[size];
        this.size = size;
        this.k = k;
        for(int i=0; i<size; i++) {
            queue[i] = i+1;
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String str = s.readLine();
        String str1[] = str.split(" ");
        int size = Integer.parseInt(str1[0]);
        int x = Integer.parseInt(str1[1]);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<size; i++) {
            list.add(i+1);
        }
        int index = 0;
        while(!list.isEmpty()) {
            index = (index + (x - 1)) % list.size();
            sb.append(list.get(index) + ", ");
            list.remove(index);
        }
        sb.delete(sb.length()-2, sb.length()-1);
        sb.insert(sb.length()-1, ">");
        System.out.println(sb.toString());
    }
}