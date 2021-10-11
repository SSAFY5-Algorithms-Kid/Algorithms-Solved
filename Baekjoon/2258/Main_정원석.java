package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2258_정육점 {
	
	static int N, M, sum = 0, ans = Integer.MAX_VALUE, preC = -1, cost = 0;
	static meat[] meats;
	static boolean flag;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		meats = new meat[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			meats[i] = new meat(w, c);
		}
		
		Arrays.sort(meats);
		
		for (int i = 0; i < N; i++) {
			sum += meats[i].w;
			if(preC == meats[i].c) cost += meats[i].c;
			else cost = meats[i].c;
			if(sum >= M) {			
				ans = Math.min(ans, cost);
				flag = true;
			}
			preC = meats[i].c;			
		}
		
		if(flag) System.out.println(ans);
		else System.out.println(-1);

	}
	
	static class meat implements Comparable<meat>{
		int w, c;

		public meat(int w, int c) {
			super();
			this.w = w;
			this.c = c;
		}

		@Override
		public int compareTo(meat o) {
			if(this.c - o.c > 0) return 1;
			else if(this.c - o.c < 0) return -1;
			else return o.w - this.w;			
		}
		
		
	}

}
