package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16953_AtoB {
	
	static int T;
	static long start, target;
	static int answer;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			answer = -1;
			start = Long.parseLong(st.nextToken());
			target = Long.parseLong(st.nextToken());

			go(start, 1);
			
			System.out.println("#" + t + " " + answer);
		}
		
	}
	
	static void go(long tmp, int step) {
		if(tmp > target) return;
		if(tmp == target) {
			if(answer != -1) answer = Math.min(answer, step);
			else answer = step;
			return;
		}
		
		go(tmp*2, step+1);
		go(tmp*10 + 1, step+1);
	}

}
