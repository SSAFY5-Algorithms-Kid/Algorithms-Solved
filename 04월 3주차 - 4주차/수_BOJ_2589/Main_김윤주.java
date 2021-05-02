import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬_bj_2589 {
	
	static int W, H, max;
	static char[][] map;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static Queue<Node> queue = new LinkedList<>();
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new char[H][W];
		visited = new boolean[H][W];
		
		for(int i=0; i<H; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 각 점에서부터 bfs
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] == 'W') continue;
				bfs(i, j);
			}
		}
		
		System.out.println(max);
	}
	
	static void bfs(int y, int x) {

		// visited init
		visitedInit();
		
		// start
		queue.offer(new Node(y, x, 0));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for(int k=0; k<4; k++) {
				int ny = n.y + dy[k];
				int nx = n.x + dx[k];
				
				if( ny<0 || nx<0 || ny>=H || nx>=W || visited[ny][nx] || map[ny][nx] == 'W' ) continue;
				
				queue.offer(new Node(ny, nx, n.t+1));
				visited[ny][nx] = true;
			}
			
			// queue의 마지막 값이 poll되었을 때 최장시간
			if(queue.isEmpty()) max = Math.max(max, n.t);
		}
	}
	
	static void visitedInit() {
		for(int i=0; i<H; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	static class Node {
		int y; int x; int t;
		
		public Node(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;		// 이동 시간
		}
	}
}
