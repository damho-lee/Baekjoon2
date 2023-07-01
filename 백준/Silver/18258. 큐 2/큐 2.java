import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class queue {
    private int top = -1;
    private int front = -1;
    private int queue[];
    public int empty() {
        if (top==front) {
            return 1;
        }
        return 0;
    }
    public int size() {
        return top-front;
    }
    public void push(int x) {
        queue[++top] = x;
    }
    public int pop() {
        if(empty()==0) {
            return queue[++front];
        }
        return -1;
    }
    public int back() {
        if(front==top)
            return -1;
        return queue[top];
    }
    public int front() {
        if(top==front)
            return -1;
        return queue[front+1];
    }
    public queue(int size) {
        queue = new int[size];
    }
 }
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String s1 = s.readLine();
        int size = Integer.parseInt(s1.substring(0,s1.length()));
        queue q = new queue(size);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
            String input_str = s.readLine();
            String str = input_str.substring(0, 3);
            if(str.equals("pus")) {
                int x = Integer.parseInt(input_str.substring(5));
                q.push(x);
            }
            else if (str.equals("pop")) {
                sb.append(q.pop()).append("\n");
            }
            else if (str.equals("bac")) {
                sb.append(q.back()).append("\n");
            }
            else if (str.equals("fro")) {
                sb.append(q.front()).append("\n");
            }
            else if (str.equals("emp")) {
                sb.append(q.empty()).append("\n");
            }
            else if (str.equals("siz")) {
                sb.append(q.size()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}