package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5014_스타트링크 {
	
	static int F, S, G, U, D, cnt = 0;
	static boolean[] chk;
	static boolean flag;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		chk = new boolean[F];
		chk[S-1] = true;
		
		loop: while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if(cur == G) {
					flag = true;
					break loop;
				}
				
				int moveUp = cur + U;
				int moveDn = cur - D;
				
				if((moveUp > 0 && moveUp <= F) && !chk[moveUp-1]) {
					q.offer(moveUp);
					chk[moveUp-1] = true;
				}
				
				if((moveDn > 0 && moveDn <= F) && !chk[moveDn-1]) {
					q.offer(moveDn);
					chk[moveDn-1] = true;
				}
			}			
			cnt++;
		}
		
		if(flag) System.out.println(cnt);
		else System.out.println("use the stairs");

	}

}
