package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 210722 thu 흙길 보수하기
 * 
 * 일단 처음에 문제부터 이해하기 어려웠다; 문제 설명의 친절도가 낮아서..
 * 로직은 정렬한 뒤 다음 웅덩이까지 여부 판단이 조금 까다로웠다.
 * 결국 위의 여부만 판단이 되고 시작점만 잘 설정해주면 판의 개수를 구해 해결할 수 있는 문제
 * */

public class No1911_흙길보수하기 {
	
	static int N, L, ans = 0;
	static pool[] pools;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		pools = new pool[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pools[i] = new pool(s, e);
		}
		
		Arrays.sort(pools);
		
		int start = 0;
		for (int i = 0; i < N; i++) {
			start = Math.max(start, pools[i].s);
			int len = 0;
			while(len < pools[i].e - start) len += L;
			
			start += len;
			ans += len / L;		
		}
		
		System.out.println(ans);

	}	
	static class pool implements Comparable<pool>{
		int s, e;

		public pool(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(pool o) {
			return this.s - o.s;
		}	
	}

}
