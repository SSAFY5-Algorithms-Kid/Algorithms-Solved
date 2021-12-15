package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * bfs로 풀었고 그래프의 깊이가 곧 눌러야 하는 버튼의 수가 된다.
 *
 */
public class Main_BOJ_5014_스타트링크_G5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());	//전체
		int S = Integer.parseInt(st.nextToken());	//현재
		int G = Integer.parseInt(st.nextToken());	//목표
		int U = Integer.parseInt(st.nextToken());	//위
		int D = Integer.parseInt(st.nextToken());	//아래

		Queue<Integer> que = new LinkedList<Integer>();
		int[] v = new int[1000001];

		que.offer(S);
		v[S]=1;		// 이걸 0으로 주면 다시 방문하면서 깊이가 꼬인다 **주의**


		while(!que.isEmpty()) {
			int now = que.poll();

			if (now==G) {
				System.out.println(v[now]-1);
				System.exit(0);
			}

			int up = now + U;
			int down = now - D;

			if (up<=F && v[up]==0) {
				que.offer(up);
				v[up]=v[now]+1;
			}

			if (down>0 && v[down]==0) {
				que.offer(down);
				v[down]=v[now]+1;
			}

		}
		System.out.println("use the stairs");

	}
}
