package ps.백준.G2;

import java.io.*;
import java.util.*;

public class BJ_G2_13460_구슬탈출2 {
	static class Ball{
		int r, c;
		boolean isRed;
		
		public Ball(int r, int c, boolean isRed) {
			this.r = r;
			this.c = c;
			this.isRed = isRed;
		}
		
		public Ball move(int d) { // 해당 방향으로 쭉 이동, 0만나면 거기서 종료, #만나면 # 이전 상태에서 반환
			for(int i=1; ; i++) {
				int nr = r + deltas[d][0] *i;
				int nc = c + deltas[d][1] *i;
				//구멍만나면?
				if(map[nr][nc] == 'O') {
					return new Ball(nr, nc, isRed);
				}else if(map[nr][nc] == '#') { // 벽 만나면 벽 이전에 멈춰야함 Ball 위치에 가벽 세우기!
					Ball newBall = new Ball(nr-deltas[d][0], nc-deltas[d][1], isRed);
					map[newBall.r][newBall.c] ='#'; // 가벽세우기 --> 이번 동작 끝나면 치우기
					return newBall;
				}
			}
		}
	}
	
	static class BallPair{
		Ball red, blue;
		
		Ball[] ordered = new Ball[2];
		
		public BallPair(Ball red, Ball blue) {
			this.red = red;
			this.blue = blue;
		}
		//상하좌우 0123
		public void reOrder(int d) {
			if(d==0) { // 상 : row 작은 놈이 먼저
				ordered[0] = red.r < blue.r?red:blue;
			}else if(d == 1) { // 하 : row 큰 놈이 먼저
				ordered[0] = red.r > blue.r?red:blue;
			}else if(d==2) { // 좌 : col 작은 놈 먼저
				ordered[0] = red.c < blue.c? red:blue;
			}else {
				ordered[0] = red.c > blue.c? red: blue;
			}
			ordered[1] = ordered[0] == red?blue:red;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, cnt;
	static char[][] map;
	static int[][] deltas = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static int holeR, holeC;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][];
		Ball red = null, blue = null;
		
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 'R') red = new Ball(r,c,true);
				else if(map[r][c] == 'B') blue = new Ball(r,c,false);
			}
		}
//		for (int r = 0; r < R; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		} // 입력확인
		
		System.out.println(bfs(red, blue));
		

	}

	private static int bfs(Ball red, Ball blue) {
		Queue<BallPair> queue = new LinkedList<>();
		boolean[][][][] visited = new boolean[R][C][R][C];
		
		queue.offer(new BallPair(red, blue));
		visited[red.r][red.c][blue.r][blue.c]= true;
		
		int turn =1, size = 0;
		while(!queue.isEmpty()) {
			size=queue.size();
			while(size-->0) {
				BallPair head = queue.poll();
				for(int d=0; d<deltas.length;d++) {
					//누가먼저 ball 이동?
					head.reOrder(d);
					// 선 후공에 따라 ball 이동
					Ball moveFirst = head.ordered[0].move(d);
					Ball moveSecond = head.ordered[1].move(d);
					// 두 공의 이동 과정에서 만들었던 가벽 제거
					if(map[moveFirst.r][moveFirst.c] == '#') {
						map[moveFirst.r][moveFirst.c]='.'; 
					}
					if(map[moveSecond.r][moveSecond.c] == '#') {
						map[moveSecond.r][moveSecond.c]= '.'; 
					}
					
					// 누가 빨간색?
					Ball redOne = moveFirst.isRed? moveFirst:moveSecond;
					Ball blueOne = redOne==moveFirst?moveSecond:moveFirst;
					
					// 공들의 이동결과에 대한 판단.
					// 파란색 공 들어가면 --> fail, 다음 시도로 진행 --> continue;
					if(map[blueOne.r][blueOne.c] == 'O') {
						continue;
					}
					// 파란색 안들어가고 빨간색이 들어가면 --> success --> return;
					else if(map[redOne.r][redOne.c] == 'O') {
						return turn;
					}
					// 둘 다 안들어가면 일반적인 BFS 탐색 진행
					else {
						if(!visited[redOne.r][redOne.c][blueOne.r][blueOne.c]) {
							visited[redOne.r][redOne.c][blueOne.r][blueOne.c] = true;
							queue.offer(new BallPair(redOne, blueOne));
						}
					}
				}
				
			}//turn 종료
			//최대 탐색은 10번까지만
			if(turn == 10) {
				break;
			}else {
				turn++;				
			}
		}
		return -1;
	}

	static String src = "5 5\r\n" + "#####\r\n" + "#..B#\r\n" + "#.#.#\r\n" + "#RO.#\r\n" + "#####";
}
