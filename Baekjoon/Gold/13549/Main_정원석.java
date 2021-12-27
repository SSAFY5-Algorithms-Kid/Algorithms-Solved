package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 210707 wed 숨바꼭질 3
 * 
 * 문제 해결 알고리즘은 bfs인 것은 쉽게 알 수 있었다.
 * 다만 커버하는 범위가 커서 효율성을 위한 코드가 필요했다.
 * 순간이동의 경우 이동 가능 위치에서 전부 0초 만에 전부 갈 수 있는 것이므로
 * 이동 가능 위치를 판별하면서 동시에 순간이동을 했다.
 * 그리고 동시에 도착지인 것을 계속해서 판별하여 불필요한 연산을 줄였다.
 * */

public class No13549_숨바꼭질3 {
	
	static int N, K, cnt = 0;
	static boolean[] chk;
	static Queue<Integer> q;
	
	static int[] move = {-1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		chk = new boolean[100001];
		q = new LinkedList<>();
		
		if(telepotation(N)) {
			System.out.println(cnt);
			q.clear();
		}
		
		loop: while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				for (int j = 0; j < 2; j++) {
					int mv = cur + move[j];
					if((mv >= 0 && mv <= 100000) && !chk[mv]) {
						if(telepotation(mv)) {
							System.out.println(cnt + 1);
							break loop;
						}						
					}
				}
			}
			cnt++;
		}		

	}
	
	static boolean telepotation(int num) {
		int n = num ;
		while(n < 100001) {
			if(n == K) return true;
			if(!chk[n]) {
				chk[n] = true;
				q.offer(n);
				n *= 2;
			}else return false;			
			
		}
		return false;
	}

}
