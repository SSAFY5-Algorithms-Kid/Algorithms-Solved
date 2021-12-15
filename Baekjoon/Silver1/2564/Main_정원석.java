import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, sCnt, answer = 0;
	static int[][] store;
	static int[] dong;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		sCnt = Integer.parseInt(br.readLine());
		
		store = new int[sCnt][2];
		dong = new int[2];
		for (int i = 0; i < sCnt; i++) {
			st = new StringTokenizer(br.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		dong[0] = Integer.parseInt(st.nextToken());
		dong[1] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < sCnt; i++) {
			if(dong[0] == 1) {
				if(store[i][0] == 1) answer += Math.abs(dong[1] - store[i][1]);
				else if(store[i][0] == 2) {
					answer += Math.min((dong[1] + store[i][1]), 2 * M - (dong[1] + store[i][1]));
					answer += N;
				} 
				else if(store[i][0] == 3) answer += (dong[1] + store[i][1]);
				else answer += (M - dong[1]) + store[i][1];
			}else if(dong[0] == 2) {
				if(store[i][0] == 1) {
					answer += Math.min((dong[1] + store[i][1]), 2 * M - (dong[1] + store[i][1]));
					answer += N;
				}
				else if(store[i][0] == 2) answer += Math.abs(dong[1] - store[i][1]);
				else if(store[i][0] == 3) answer += (N - store[i][1]) + dong[1];
				else answer += (M - dong[1]) + (N - store[i][1]);
			}else if(dong[0] == 3) {
				if(store[i][0] == 1) answer += (dong[1] + store[i][1]);
				else if(store[i][0] == 2) answer += ((N - dong[1]) + store[i][1]);
				else if(store[i][0] == 3) answer += Math.abs(dong[1] - store[i][1]);
				else {
					answer += Math.min(dong[1] + store[i][1], 2 * N - (dong[1] + store[i][1]));
					answer += M;
				}
			}else {
				if(store[i][0] == 1) answer += ((M - store[i][1]) + dong[1]);
				else if(store[i][0] == 2) answer += (N - dong[1]) + (M - store[i][1]);
				else if(store[i][0] == 3) {
					answer += Math.min((dong[1] + store[i][1]), 2 * N - (dong[1] + store[i][1]));
					answer += M;
				}else answer += Math.abs(dong[1] - store[i][1]);
			}
		}
		
		System.out.println(answer);
		

	}

}
