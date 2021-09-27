package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2012_등수매기기_S3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] rank = new int[N];
		for (int i = 0; i < N; i++) {
			rank[i]=sc.nextInt();
		}
		Arrays.sort(rank);
		
		long ans = 0;
		for (int i = 0; i < N; i++) {
			ans += Math.abs(rank[i]-(i+1));
		}
		
		System.out.println(ans);
	}

}
