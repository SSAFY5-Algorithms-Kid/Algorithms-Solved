import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] number;
	static int[] students;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		students = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			students[i] = i+1;
		}
		
		for (int i = 0; i < N; i++) {
			shift(number[i], i);
		}
		
		for (int i = 0; i < N-1; i++) {
			System.out.print(students[i]+" ");
		}
		System.out.print(students[N-1]);
	}
	
	static void shift(int num, int n) {
		int start = n - num;
		int temp = students[n];
		for (int i = n-1; i >= start; i--) {
			students[i+1] = students[i];
		}
		students[start] = temp;
		
	}
}
