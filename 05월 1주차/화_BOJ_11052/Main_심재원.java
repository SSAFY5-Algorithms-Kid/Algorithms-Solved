package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_11052_카드구매하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int[] P, max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(input.readLine());
		P = new int[N+1];
		max = new int[N+1];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 1; n < N+1; n++) {
			P[n] = Integer.parseInt(tokens.nextToken());
		}
		
		max[0] = 0;
		for (int n = 1; n <= N; n++) {
			for (int p = 1; p <= n; p++) {				
				max[n] = Math.max(max[n], max[n-p] + P[p]);
				System.out.println("n: "+n +" "+ max[n]);
			}
		}
		System.out.println(max[N]);
	}
	
	static String src = "4\r\n" + 
			"3 5 15 16";
}
