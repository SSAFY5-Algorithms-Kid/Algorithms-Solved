package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class No1167_트리의지름 {
	
	static int V;
	static ArrayList<Node>[] adjList;
	static Node ret;
	static boolean[] chk;
	static int max = 0;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V+1];
		chk = new boolean[V+1];
		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			adjList[v] = new ArrayList<>();
			while(true) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == -1) break;
				else {
					adjList[v].add(new Node(tmp, Integer.parseInt(st.nextToken())));
				}
			}
		}
		Node maxNode = dfs(adjList[1].get(0), 0);
		chk = new boolean[V+1];
		ret = null; max = 0;
		dfs(maxNode, 0);
		
		System.out.println(max);		
	}
	
	static class Node{
		int v;
		int w;
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}		
		
	}
	
	static Node dfs(Node v, int dist) {
		chk[v.v] = true;
		
		for (Node tmp : adjList[v.v]) {
			if(!chk[tmp.v]) dfs(tmp, dist + tmp.w);
		}
		
		if(max < dist) {
			ret = v; max = dist;
		}
		return ret;
	}

}
