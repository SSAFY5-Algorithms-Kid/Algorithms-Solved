package BOJ;

import java.io.*;
import java.util.*;

/**
 * @author JAEWOO SHIM
 * @date  
 *
 * <문제>
 * 크키가 R*C 인 목장에서 W는 늑대 .은 빈칸 S는 양이다.
 * 늑대는 상하좌우로 이동가능
 * 늑대가 양에 도달할 수 없게 울타리를 친다.
 * 
 * <풀이>
 * queue를 이용해서 bfs를 돌렸는데 메모리초과가 남. 이유를 모르겠음..
 * for문으로 그냥 돌렸더니 pass..
 * 
 * 울타리를 설치해주지 않으면 틀렸다고 나온다.
 * 
 * StringBuilder를 이용해주면 시간을 매우 단축할 수 있다.
 * 
 */
public class Main_BOJ_S4_16956_늑대와양 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String ss = br.readLine();
			map[i]=ss.toCharArray();
		}
		// 입력 완료
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j]=='W') {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if (!(nr>=0 && nr<R && nc>=0 && nc<C)) continue;
						if (map[nr][nc]=='.') {
							map[nr][nc]='D';
						}
						if (map[nr][nc]=='S') {
							System.out.println("0");
							System.exit(0);
						}
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		System.out.println("1");
		for (int i = 0; i < R; i++) {
			sb.append(map[i]);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
