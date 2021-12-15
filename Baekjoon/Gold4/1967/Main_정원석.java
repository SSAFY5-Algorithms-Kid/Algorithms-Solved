package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 210708 thu 트리의 지름
 * 
 * 효율성 고려에 대한 필요성을 느낀 문제
 * 첨에는 문제를 잘못 이해하고 다시 풀었다.
 * 다시 풀었을 때 모든 정점에 대해서 최대 지름의 길이를 구하는 완전 탐색 방법으로 접근해서 해결을 했다.
 * 하지만 다른 사람들의 풀이에 비해 오버 메모리와 시간이 들어서 해설을 보고 효율적인 풀이를 알게 되었다.
 * 효율성 고려를 위한 연습이 필요한 것 같다.
 * */

public class No1967_트리의지름 {
	
	static int V, ans = 0, ans_ind = 0;
	static boolean[] chk;
	static ArrayList<node>[] adjList;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[V+1];		
		
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < V-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adjList[v].add(new node(u, e));
			adjList[u].add(new node(v, e));
		}
		chk = new boolean[V+1];
//		for (int i = 1; i <= V; i++) {
//			chk = new boolean[V+1];
//			dfs(i, 0);
//		}
		
		dfs(1, 0);
		
		chk = new boolean[V+1];
		ans = 0;
		
		if(ans_ind != 0) dfs(ans_ind, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int v, int w) {
		
		chk[v] = true;
//		ans = Math.max(ans, w);
		
		if(ans < w) {
			ans = w;
			ans_ind = v;
		}
		
		for (int i = 0, size = adjList[v].size(); i < size; i++) {
			node cur = adjList[v].get(i);
			if(!chk[cur.v]) {
				dfs(cur.v, w + cur.e);
			}
		}
	}
	
	static class node{
		int v, e;

		public node(int v, int e) {
			super();
			this.v = v;
			this.e = e;
		}
		
	}
}
