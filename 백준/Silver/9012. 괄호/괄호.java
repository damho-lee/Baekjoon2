import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = Integer.parseInt(s.nextLine());
		for(int i=0; i<size; i++) {
			String input_str = s.nextLine();
			//System.out.println(input_str);
			boolean flag = true;
			Stack<Character> stack = new Stack<>();
			for(int j=0; j<input_str.length(); j++) {
				if(input_str.charAt(j) == '(')
					stack.push('(');
				else if (input_str.charAt(j)== ')'){
					if(stack.empty()) {
						flag=false;
						break;
					}
					char x = stack.pop();
					if(x == '(')
						continue;
					else {
						flag=false;
						break;
					}
				}
			}
			if(stack.empty()&&flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		s.close();
	}
}

