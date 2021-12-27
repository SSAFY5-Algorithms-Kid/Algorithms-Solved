package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 210707 wed 이분그래프
 * 
 * 처음 문제를 읽고 이분그래프에 대해서 잘못 이해해서
 * 해결방법이 쉽게 떠올리지 못해서 해법을 보고 개념을 이해하고 다시 풀어보았다.
 * bfs로 인접 정점들 탐색하면서 마킹하고 마킹값이 같은 경우 NO
 * 정상적으로 탐색이 끝나면 YES를 하여 문제를 해결할 수 있었다.
 * */

public class No1707_이분그래프 {
	
	static int T, V, E;
	static int[] chk;
	static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		loop: for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			chk = new int[V+1];
			adjList = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				
				adjList[v].add(u);
				adjList[u].add(v);
			}
			
			for (int i = 1; i <= V; i++) {
				if(chk[i] != 0) continue;
				
				int mark = 1;
				
				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				chk[i] = mark;
				
				while(!q.isEmpty()) {
					int size = q.size();
					for (int j = 0; j < size; j++) {
						int cur = q.poll();
						for (int k = 0, len = adjList[cur].size(); k < len; k++) {
							int v = adjList[cur].get(k);
							if(chk[v] == mark) {
								System.out.println("NO");
								continue loop;
							}else if(chk[v] == 0) {
								q.offer(v);
								chk[v] = (3 - mark);
							}
						}
					}
					mark = (3 - mark);
				}
			}
			System.out.println("YES");
		}

	}

}
