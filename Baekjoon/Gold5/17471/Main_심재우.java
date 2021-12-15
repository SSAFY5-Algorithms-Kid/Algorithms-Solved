package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author JAEWOO SHIM
 * @date 21.03.27
 * 
 * 1. 구역을 뽑는다 -> 부분집합을 이용
 * 2. union-find? 이용해서 (각각) 연결된 구역인지 확인
 * 3. 각 구역의 인구수 차이 도출
 * <제약사항>
 *	모든 값은 정수
 *	양방
 *	선거구는 구역을 적어도 하나 포함해야한다
 *	
 *구역의 개수 N
 *N개의 각 구역의 인구수
 *순서대로 각 구역에 연결된 개수 / 구역번호 / 구역번호
 *
 *출력은 각 구역의 인구수 차의 최소값
 */
public class Main_BOJ_G5_17471_게리맨더링 {

	static int N;	// 구역의 개수
	static int[] people;	//가중치
	static ArrayList<Integer>[] node;	
	static boolean[] v;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i]=Integer.parseInt(st.nextToken());
		}
		node = new ArrayList[N];	// 리스트 배열은 초기세팅을 반드시 해줘야한다.
		for (int i = 0; i < N; i++) {
			node[i]=new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				node[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		// 입력 완료 ====
		ans = Integer.MAX_VALUE;
		v = new boolean[N];
		subset(0, 0);
		if (ans<Integer.MAX_VALUE) {
			System.out.println(ans);
		}else {
			System.out.println("-1");
		}
		
	}
	// 부분집합을 이용
	private static void subset(int cnt, int sum) {
		if (cnt==N) {
			if (sum==6 || sum==0) {
				return;
			}
			int apop = 0;
			int bpop = 0;
			if (bfs()) {
				for (int i = 0; i < N; i++) {
					if (v[i]) {
						apop+=people[i];
					}else {
						bpop+=people[i];
					}
				}
			}else {
				return;
			}
			int tmp = Math.abs(apop-bpop);
			ans = Math.min(tmp, ans);
			return;
		}
		v[cnt]=true;
		subset(cnt+1, sum+1);
		v[cnt]=false;
		subset(cnt+1, sum);
	}
	
	static int sums;
	private static boolean bfs() {
		boolean[] vv = new boolean[N];
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			if (v[i]) {
				que.offer(i);
				vv[i]=true;
				break;
			}
		}
		
		while(!que.isEmpty()) {
			int curr = que.poll();
			if (v[curr]) {
				for (int i = 0; i < node[curr].size(); i++) {
					int next = node[curr].get(i);
					if (vv[next]) {
						continue;
					}
					if (v[next]) {
						que.offer(next);
						vv[next]=true;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				que.offer(i);
				vv[i]=true;
				break;
			}
		}
		
		while(!que.isEmpty()) {
			int curr = que.poll();
			if (!v[curr]) {
				for (int i = 0; i < node[curr].size(); i++) {
					int next = node[curr].get(i);
					if (vv[next]) {
						continue;
					}
					if (!v[next]) {
						que.offer(next);
						vv[next]=true;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (!vv[i]) {
				return false;
			}
		}
		return true;
		
	}

}
















