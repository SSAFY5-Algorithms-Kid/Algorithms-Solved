package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11399_ATM {
	
	static int T, N;
	static int[] time;
	static int answer;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			
			time = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(time);
			answer += time[0];
			
			for (int i = 1; i < N; i++) {
				time[i] += time[i-1];
				answer += time[i];
			}
			System.out.println("#" + t + " " +answer);
		}
		

	}

}
