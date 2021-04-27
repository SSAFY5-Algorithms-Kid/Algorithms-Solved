import java.util.*;

public class Solution_contact {
	static int max; //마지막 최대값을 구하기 위한 변수 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int L = sc.nextInt();
			int start = sc.nextInt();
			int[][] map = new int[101][101];
			boolean[] visit = new boolean[101];
			
			for(int i = 0; i < L/2; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = 1;
			}
			//입력단계 
			Queue<Integer> q = new LinkedList<>();
			q.offer(start); //시작점 큐에 넣기 
			visit[start] = true;
			while(!q.isEmpty()) {
				max = 0;
				int size = q.size(); //큐에 있는 모든 거 한번에 빼기 (depth를 따로 안넣어도된다)
				for(int i = 0; i < size; i++) {
					int temp = q.poll();
					if(max<temp)
						max=temp;
					for(int j = 1; j < 101; j++) {
						if(map[temp][j]==1&&visit[j]==false) {
							q.offer(j);	
							visit[j] = true;
						}
					}
				}	
			}
			System.out.println("#"+tc+" "+max);
			
		}
	}
}
