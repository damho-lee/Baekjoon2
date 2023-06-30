import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<Double>();
        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());
        String problem = s.nextLine();
        int arr[] = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(s.nextLine());
        }
        char chararr[] = problem.toCharArray();
        int i = 0;
        HashMap<Character, Double> hm = new HashMap<>();
        for(int k=0; k<problem.length(); k++) {
            if (chararr[k] >= 'A' && chararr[k] <= 'Z') {
                if(!hm.containsKey(chararr[k])) {
                    hm.put(chararr[k], (double) arr[i]);
                    i++;
                }
            }
        }
        for(int k=0; k<problem.length(); k++) {
            if(chararr[k] >= 'A' && chararr[k] <= 'Z') {
                stack.push(hm.get(chararr[k]));
            }
            else if(chararr[k] == '+' || chararr[k] == '-' || chararr[k] == '*' || chararr[k] == '/') {
                Double y = stack.pop();
                Double x = stack.pop();
                if(chararr[k] == '+') {
                    stack.push(x + y);
                }
                else if(chararr[k] == '-') {
                    stack.push(x - y);
                }
                else if(chararr[k] == '*') {
                    stack.push(x * y);
                }
                else if(chararr[k] == '/') {
                    stack.push(x / y);
                }
            }
        }
        s.close();
        System.out.printf("%.2f", stack.pop());
    }
}