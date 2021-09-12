import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  
 *
 *	<제약 사항>
 *	노드는 최대 100개 이다
 *	1~100까지의 번호 중에서 비어있는 번호가 있을 수 있다.
 *	가중치는 1로 일정하다
 *	한 노드에서 다음 노드로는 한번에 이동한다.
 *	갈 수 없는 노드가 존재한다.
 *	
 *	<풀이>
 *	bfs 문제이다. 
 *	문제에서 요구하는 답이 제일 마지막으로 도달한 노드들 중에서
 *	가장 큰 번호를 골라내야하므로 깊이를 체크해야한다.
 *	
 *	v배열을 이용해서 v의 값이 가장 큰 녀석들이 제일 마지막에 방문한
 *	노드로 판별했다.
 */
public class Solution_D4_1238_contact {

	static int[][] graph;	// 주어진 그래프
	static int[] v;	// 깊이를 판단할 배열
	static int ans;	//답
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			graph = new int[101][101];	// 최대 100개라고 했으므로 101,101로 잡아준다.
			v = new int[101];	// 100개가 한개씩 간다고 했을때 최대 깊이는 100이다.
			
			int N = sc.nextInt();	// 입력받는 데이터의 길이
			int start = sc.nextInt();	// 시작점
			
			// 입력이 (from to)의 반복이므로 N/2까지 for문을 돌려준다.
			for (int i = 0; i < N/2; i++) {
				int from = sc.nextInt();	//여기서
				int to = sc.nextInt();	//여기로 간다.
				graph[from][to]=1;	//가중치는 1로 고정
			}
			// ==== 입력완료
			
			ans = Integer.MIN_VALUE; 	// 가장 큰 값을 고르는게 답이라서 제일 작은수로 초기세팅해준다
			bfs(start);	// bfs 시작
			
			//출력
			System.out.println("#"+t+" "+ans);
			
		}
	}

	static void bfs(int start) {
		
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(start);
		v[start]=1;	// v가 값이 있다는 것은 방문을 했다는 의미이기도 하다
		int max = 0;	// 최대 깊이
		while(!que.isEmpty()) {
			int qq = que.poll();
			
			for (int i = 1; i < 101; i++) {
				if (graph[qq][i]!=1 || v[i]!=0) {	//연결이 되어있지않거나 방문했으면 continue
					continue;
				}
				if (graph[qq][i]==1) {
					que.offer(i);
					v[i]=v[qq]+1;	// 깊이 + 1
					max = Math.max(v[i], max);	// 최대깊이 갱신
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			// 최대깊이의 v[] 값들 중에서 가장 큰걸 고른다.
			if (v[i]==max) {
				ans = Math.max(i, ans);
			}
		}
	}
}
