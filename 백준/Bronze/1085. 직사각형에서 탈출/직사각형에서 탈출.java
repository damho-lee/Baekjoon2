import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		int w = s.nextInt();
		int h = s.nextInt();
		int a = Math.min(x, w-x);
		int b = Math.min(y, h-y);
		System.out.print(Math.min(a, b));
		s.close();
	}
}