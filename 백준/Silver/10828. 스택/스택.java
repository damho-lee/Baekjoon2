import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class stack {
    private int top = -1;
    private int stack[];
    public int empty() {
        if (top == -1) {
            return 1;
        }
        return 0;
    }
    public int size() {
        return top+1;
    }
    public void push(int x) {
        stack[++top] = x;
    }
    public int pop() {
        if(empty()==0) {
            return stack[top--];
        }
        return -1;
    }
    public int top() {
        if(top==-1)
            return -1;
        return stack[top];
    }
    public stack(int size) {
        stack = new int[size];
    }
 }
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String s1 = s.readLine();
        int size = Integer.parseInt(s1.substring(0,s1.length()));
        stack st = new stack(size);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
            String input_str = s.readLine();
            String str = input_str.substring(0, 3);
            if(str.equals("pus")) {
                int x = Integer.parseInt(input_str.substring(5));
                st.push(x);
            }
            else if (str.equals("pop")) {
                sb.append(st.pop()).append("\n");
            }
            else if (str.equals("top")) {
                sb.append(st.top()).append("\n");
            }
            else if (str.equals("emp")) {
                sb.append(st.empty()).append("\n");
            }
            else if (str.equals("siz")) {
                sb.append(st.size()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}