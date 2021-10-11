package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 210706 화 DSLR
 * 
 * 문제 해결 알고리즘은 bfs를 사용하면 된다.
 * 다만 방문 여부를 배열 index로 체크하는 것이 문제 해결의 중요 포인트이다.
 * input이 워낙 커서 자칫 잘못하면 시간초과가 발생한다.
 * */

public class No9019_DSLR {
	
	static int T, A, B;
	static String answer;
	static String[] ans;
	static boolean[] chk;
	static Queue<Integer> q;
	
	static String[] DSLR = {"D", "S", "L", "R"};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			answer = "";
			ans = new String[10000];
			chk = new boolean[10000];
			q = new LinkedList<>();
			Arrays.fill(ans, "");
			
			q.offer(A);
			chk[A] = true;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				if(cur == B) {
					System.out.println(ans[cur]);
					break;
				}
				for (int j = 0; j < 4; j++) {
					int num = 0;
					if(DSLR[j].equals("D")) {
						num = (cur * 2) % 10000;						
					}else if(DSLR[j].equals("S")) {
						num = (cur + 9999) % 10000;
					}else if(DSLR[j].equals("L")) {
						int r = cur / 1000;
						int q = cur % 1000;
						num = q * 10 + r;
					}else if(DSLR[j].equals("R")) {
						int r = cur / 10;
						int q = cur % 10;
						num = q * 1000 + r;
					}
					if(!chk[num]) {
						q.offer(num);
						chk[num] = true;
						ans[num] = ans[cur] + DSLR[j];
					}
				}
			}
			
		}
	}	

}
