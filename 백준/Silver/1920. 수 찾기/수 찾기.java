import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size_x = Integer.parseInt(s.nextLine());
		int[] arr_x = new int[size_x];
		for(int i=0; i<size_x; i++) {
			arr_x[i] = s.nextInt();
		}
		Arrays.sort(arr_x);
		s.nextLine();
		int size_y = Integer.parseInt(s.nextLine());
		for (int i = 0; i<size_y; i++) {
			int x = s.nextInt();
			int res = BinarySearch(arr_x, x);
			System.out.println(res);
		}
		s.close();
	}
	public static int BinarySearch(int[] arr, int x) {
		int i = 0;
		int j = arr.length;
		int center = arr.length/2;
		int key = x;
		while(i<j) {
			if(arr[center] == key) {
				break;
			}
			if(key < arr[center]) {
				j = center-1;
				center = (i+j)/2;
			}
			else if(key > arr[center]) {
				i = center+1;
				center = (i+j)/2;
			}
		}
		if(center >= arr.length)
			center = arr.length-1;
		if (arr[center] == key) 
			return 1;
		else 
			return 0;
	}
}
