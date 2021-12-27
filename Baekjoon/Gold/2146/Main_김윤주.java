import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_김윤주 {
	
	static int N, min=Integer.MAX_VALUE;
	static int[][] map;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// #1 input
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// #2
		rename();
		
		// #3
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] !=0) {
					cal(i, j, map[i][j]);
				}
			}
		}
		
		System.out.println(min);

	}
	
	// #2 섬 구역 다시 명명
	static void rename() {
		boolean[][] visited = new boolean[N][N];
		Queue<Node> queue = new LinkedList<>();
		int num = 0;
		
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					num++;
					
					map[i][j] = num;
					visited[i][j] = true;
					queue.offer(new Node(i, j));
					
					while(!queue.isEmpty()) {
						Node n = queue.poll();
						
						for(int k=0; k<4; k++) {
							int ky = dy[k] + n.y;
							int kx = dx[k] + n.x;
							
							if(ky<0 || kx<0 || ky>=N || kx>=N || map[ky][kx]==0 || visited[ky][kx]) continue;
							
							map[ky][kx] = num;
							visited[ky][kx] = true;
							queue.offer(new Node(ky, kx));
						}
					}
				}
			}
		}
	}
	
	// #3 bfs로 다른 섬까지의 최소 거리 측정
	static void cal(int y, int x, int num) {
		boolean[][] visited = new boolean[N][N];
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(new Node(y, x, 0));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for(int k=0; k<4; k++) {
				int ky = dy[k] + n.y;
				int kx = dx[k] + n.x;
				
				if(ky<0 || kx<0 || ky>=N || kx>=N || map[ky][kx]==num || visited[ky][kx]) continue;
				else if(map[ky][kx]!=0) {
					min = Math.min(min, n.c);
					return;
				}
				
				visited[ky][kx] = true;
				queue.offer(new Node(ky, kx, n.c+1));
			}
		}
	}
	
	static class Node {
		int y, x, c;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		public Node(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}

}
