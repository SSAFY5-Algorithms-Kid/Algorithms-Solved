package BOJ;

import java.io.*;
import java.util.*;

public class Main_BOJ_S2_1260_DFS와BFS {

	static int N, M, V;
	static int[][] node;
	static boolean[] dv, bv;
	static ArrayList<Integer> dflist;
	static ArrayList<Integer> bflist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		node = new int[N+1][N+1];
		dv = new boolean[N+1];
		bv = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b]=node[b][a]=1;
		}
		dflist = new ArrayList<>();
		bflist = new ArrayList<>();
		
		dflist.add(V);
		dv[V]=true;
		dfs(V);
		
		bfs(V);
		
		for (int i = 0; i < dflist.size(); i++) {
			System.out.print(dflist.get(i)+" ");
		}
		System.out.println();
		for (int i = 0; i < bflist.size(); i++) {
			System.out.print(bflist.get(i)+" ");
		}
	}
	
	static void dfs(int start) {
		for (int i = 1; i <= N; i++) {
			if (dv[i]) {
				continue;
			}
			if(node[start][i]==1) {
				dflist.add(i);
				dv[i]=true;
				dfs(i);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(start);
		bflist.add(start);
		bv[start]=true;
		
		while(!que.isEmpty()) {
			int curr = que.poll();
			
			for (int i = 1; i <= N; i++) {
				if (bv[i]) {
					continue;
				}
				if (node[curr][i]==1) {
					que.offer(i);
					bflist.add(i);
					bv[i]=true;
				}
			}
		}
	}

}
