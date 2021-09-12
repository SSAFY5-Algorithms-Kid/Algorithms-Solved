package May_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_No11497_통나무건너뛰기 {
	
	static int T, N, answer;
	static Integer[] log, sort;	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			log = new Integer[N];
			sort = new Integer[N];
			answer = Integer.MIN_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				log[i] = Integer.parseInt(st.nextToken());				
			}
			
			int ind = (N % 2 == 0) ? N/2 - 1 : N/2;
			int gap = 1;
			
			Arrays.sort(log, Collections.reverseOrder());
			Arrays.fill(sort, -1);
			sort[ind] = log[0];
			
			for (int i = 1; i < N; i++) {
				if(sort[ind + gap] == -1) sort[ind + gap] = log[i];
				else {
					sort[ind - gap++] = log[i];
				}
			}
			
			for (int i = 0; i < N; i++) {
				answer = Math.max(answer, Math.abs(sort[i] - sort[(i+1) % N]));
			}
			System.out.println(answer);
		}

	}

}
