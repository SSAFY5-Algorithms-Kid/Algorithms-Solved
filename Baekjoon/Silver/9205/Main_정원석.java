import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T;
	static int N;
	static boolean[] chk;
	static Node[] nodeList;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			chk = new boolean[N+2];
			nodeList = new Node[N+2];
			
			boolean answer = false;
			
			for (int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				nodeList[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Queue<Node> q = new LinkedList<>();
			q.offer(nodeList[0]);
			chk[0] = true;
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				if(Math.abs(cur.x - nodeList[N+1].x) + Math.abs(cur.y - nodeList[N+1].y) <= 1000) {
					answer = true;
					break;
				}
				for (int i = 0; i < N+2; i++) {
					if(chk[i]) continue;
					if(Math.abs(cur.x - nodeList[i].x) + Math.abs(cur.y - nodeList[i].y) <= 1000) {
						q.offer(nodeList[i]);
						chk[i] = true;
					}
				}
			}
			if(answer) System.out.println("happy");
			else System.out.println("sad");
			
			
		}

	}
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
