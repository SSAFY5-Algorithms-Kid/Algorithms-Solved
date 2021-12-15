package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_1707_이분그래프_G4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		a: for (int t = 1; t <= TC; t++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			
//			int[][] node = new int[V+1][V+1]; 이렇게 하면 20000*20000 이라 4억.. 메모리 초과가 납니다..ㅠㅠ
			
			ArrayList<ArrayList<Integer>> node = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				node.add(new ArrayList<Integer>());
			}
			
			int[] v = new int[V];
			
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				
//				node[a][b]=node[b][a]=1;
				node.get(a).add(b);
				node.get(b).add(a);
			}
			
			Queue<Integer> que = new LinkedList<>();
			
			int c = -1;
			for (int ii = 0; ii < V; ii++) {
				if (v[ii]==0) {
					que.offer(ii);
					v[ii]=1;
					while(!que.isEmpty()) {
						int now = que.poll();
						
						for (int i = 0; i < node.get(now).size(); i++) {
							if (v[node.get(now).get(i)]==0) {
								que.offer(node.get(now).get(i));
								v[node.get(now).get(i)]=v[now]*c;
							}
							if(v[node.get(now).get(i)]!=0 && v[node.get(now).get(i)]==v[now]){
								System.out.println("NO");
								continue a;	// break가 아니라 continue...
							}
						}
						
						
					}
				}
			}
			System.out.println("YES");
		}
	}

}

/*
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2

*/
