package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_G5_1600_말이되고픈원숭이 {
	
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visit;
    static int tot;
    static class Monkey{
        int r;
        int c;
        int cnt;
        int k;
        
        Monkey(int r, int c, int cnt, int k){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.k = k;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        
        map = new int[H][W];	//H W 임 인덱스 에러 주의!
        visit = new boolean[H][W][K+1];	// K가 최대 30개니까 1개 더 줌 K+1=31
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        visit[0][0][0] = true;
        solve();
    }

    // 동서남북 좌우상하(말)
    static int[] dr = {1,-1, 0, 0};
    static int[] dc = {0, 0, 1, -1}; 
    static int[] hr = {-2, -2, 2, 2, 1, -1, 1, -1};
    static int[] hc = {1, -1, 1, -1, 2, 2, -2, -2};
	static void solve() {	//bfs
		Queue<Monkey> q = new LinkedList<Monkey>();
		q.add(new Monkey(0,0,0,K));
		
		while(!q.isEmpty()) {
			Monkey cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int cnt = cur.cnt;
			int curK = cur.k;
			
			if (r==W-1 && c==H-1) {
				System.out.println(cnt);
				return;
			}
			if(!check(r,c)) continue;
			if(map[c][r]==1)continue;
			if(visit[c][r][curK])continue;
			visit[c][r][curK]=true;
			//monkey
			for (int m = 0; m < 4; m++) {
				int nr=r+dr[m];
				int nc=c+dc[m];
				q.add(new Monkey(nr,nc,cnt+1,curK));
			}
			//horse
			if(curK==0)continue;
			for (int h = 0; h < 8; h++) {
				int nr=r+hr[h];
				int nc=c+hc[h];
				q.add(new Monkey(nr,nc,cnt+1,curK-1));
			}
		}
		System.out.println("-1");
//		return;
	}

	static boolean check(int r, int c) {
		return r>=0 && r<W && c>=0 && c<H;
	}
}
