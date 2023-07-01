import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class deque {
    private int front = 0;
    private int back = 0;
    private int[] deq;
    private int size=10000;
    public deque() {
        deq = new int[size];
    }
    public boolean full() {
        if(front == (back+1)%size)
            return true;
        return false;
    }
    public int empty() {
        if(front==back) {
            return 1;
        }
        return 0;
    }
    public int size() {
        return front<=back ? back-front : (back+size)-front;
    }
    public void push_front(int x) {
        if(!full()) {
            front = (front-1+size)%size;
            deq[front] = x;
        }
    }
    public void push_back(int x) {
        if(!full()) {
            deq[back++] = x;
            back = back%size;
        }
    }
    public int pop_front() {
        if(empty()==1) {
            return -1;
        }
        int result = deq[front];
        front = (front+1)%size;
        return result;
    }
    public int pop_back() {
        if(empty()==1) {
            return -1;
        }
        back = (back-1+size)%size;
        return deq[back];
    }
    public int front() {
        if(empty()==1) {
            return -1;
        }
        return deq[front];
    }
    public int back() {
        if(empty()==1) {
            return -1;
        }
        return deq[(back-1+size)%size];
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split("\n");
        int size = Integer.parseInt(str[0]);
        deque d = new deque();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
            str = br.readLine().split(" ");
            if(str[0].equals("push_back")) {
                d.push_back(Integer.parseInt(str[1]));
            }
            else if(str[0].equals("push_front")) {
                d.push_front(Integer.parseInt(str[1]));
            }
            else if(str[0].equals("pop_front")) {
                sb.append(d.pop_front() + "\n");
            }
            else if(str[0].equals("pop_back")) {
                sb.append(d.pop_back() + "\n");
            }
            else if(str[0].equals("size")) {
                sb.append(d.size() + "\n");
            }
            else if(str[0].equals("empty")) {
                sb.append(d.empty() + "\n");
            }
            else if(str[0].equals("front")) {
                sb.append(d.front() + "\n");
            }
            else if(str[0].equals("back")) {
                sb.append(d.back() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}