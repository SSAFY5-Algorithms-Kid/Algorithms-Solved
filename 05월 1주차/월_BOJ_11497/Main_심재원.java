package ps.백준.S1;
/**
 * @since 2021. 5. 8.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_11497_통나무건너뛰기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N, max;
	static int[] wood;
	static int[] ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(input.readLine());
			wood = new int[N];
			ans = new int[N];
			max = Integer.MIN_VALUE;
			tokens = new StringTokenizer(input.readLine());
			for (int n = 0; n < N; n++) {
				wood[n] = Integer.parseInt(tokens.nextToken());				
			}
			Arrays.sort(wood); // 배열 오름차순으로 정렬
			
			int left = 0;
			int right = N-1;
			
			for (int n = 0; n < N; n++) {
				if(n%2==0) {
					ans[left++] = wood[n];
				}
				else{
					ans[right--] = wood[n];
				}
			}
			System.out.println(Arrays.toString(ans));
			
			for (int n = 1; n < N; n++) {
				max = Math.max(max, Math.abs(ans[n]-ans[n-1]));
			}
			System.out.println(max);
		}
	}
	
	static String src = "3\r\n" + 
			"7\r\n" + 
			"13 10 12 11 10 11 12\r\n" + 
			"5\r\n" + 
			"2 4 5 7 9\r\n" + 
			"8\r\n" + 
			"6 4 8 2 9 3 8 1";
}
