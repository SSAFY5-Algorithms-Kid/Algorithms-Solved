package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1744_수묶기 {
	
	static int N, answer = 0;
	static Integer[] num;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		num = new Integer[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		int left = 0;
		int right = N-1;
		
		for (; left < right; left += 2) {
			if(num[left] < 1 && num[left+1] < 1) answer += (num[left] * num[left+1]);
			else break;
		}
		
		for (; right > 0; right -= 2) {
			if(num[right] > 1 && num[right-1] > 1) answer += (num[right] * num[right-1]);
			else break;
		}
		
		for (; left <= right; left++) answer += num[left];
		
		System.out.println(answer);

	}

}
