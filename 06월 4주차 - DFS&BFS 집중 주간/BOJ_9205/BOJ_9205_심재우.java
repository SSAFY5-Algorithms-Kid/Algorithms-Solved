package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_S1_9205_맥주마시면서걸어가기 {

	static int T, N;
	static int hx, hy, fx, fy;
	static int[][] dist;
	static int INF = 999999;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());	// 편의점 개수
			
			int[][] conb = new int[N+2][2];
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				conb[i][0]= Integer.parseInt(st.nextToken());
				conb[i][1]= Integer.parseInt(st.nextToken());
            }
			dist = new int[N+2][N+2];	// 집 + 편의점100개 + 페 = 102			
			
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					if (i==j) {
						continue;
					}
					int distance = Math.abs(conb[i][0]-conb[j][0])
							+ Math.abs(conb[i][1]-conb[j][1]);
					if (distance <= 50*20) {
						dist[i][j]=1;
					}
					if (dist[i][j]==0) {
						dist[i][j]=INF;
					}
				}
			}
			
			//플로이드워샬
			// 경 출 목
			for (int k = 0; k < N+2; k++) {
				for (int i = 0; i < N+2; i++) {
					if (i==k) {
						continue;
					}
					for (int j = 0; j < N+2; j++) {
						if (i==j || j==k) {
							continue;
						}
						if(dist[i][j] > dist[i][k]+dist[k][j]) {
							dist[i][j] = dist[i][k]+dist[k][j];
						}
					}
				}
			}
			if (dist[N+1][0]>0 && dist[N+1][0]<INF) {
				System.out.println("happy");
			}else
				System.out.println("sad");
			
			
			
			
		}
	}

}
