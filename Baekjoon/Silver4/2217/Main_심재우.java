package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2217_로프_S4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] rope = new int[N];
		
		for (int i = 0; i < N; i++) {
			rope[i]=sc.nextInt();
		}
		
		Arrays.sort(rope);
		
		int ans = 0;
		for (int i = 0, j=N ; i < N; i++, j--) {
			ans = Math.max(ans, rope[i]*j);
		}
		
		System.out.println(ans);
	}
}
