import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, answer = Integer.MAX_VALUE;
	static int[] pop;
	static ArrayList<Integer>[] adj;
	static int[] gu1, gu2;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		
		adj = new ArrayList[N+1];
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			adj[i] = new ArrayList<>();
			
			for (int j = 0; j < size; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}			
		}
		
		for (int i = 1; i <= N/2; i++) {
			gu1 = new int[i];
			gu2 = new int[N-i];
			comb(1, 0, i);
		}
		
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);

	}
	
	static void makegu2() {
		int ind = 0;
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			flag = false;
			for (int j = 0; j < gu1.length; j++) {
				if(i == gu1[j]) flag = true;
			}
			if(!flag) gu2[ind++] = i;
		}
	}
	
	static void comb(int srcind, int tgtind, int r) {
		if(tgtind == r) {
			makegu2();
			check();
			return;
		}
		
		if(srcind == N+1) return;
		
		comb(srcind+1, tgtind, r);
		gu1[tgtind] = srcind;
		comb(srcind+1, tgtind+1, r);
	}
	
	static void check() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(gu1[0]);
		boolean[] chk = new boolean[N+1];
		chk[gu1[0]] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(Integer i : adj[cur]) {
				if(chkin(i, 1) && !chk[i]) {
					q.offer(i);
					chk[i] = true;
				}
			}
		}
		for (int i = 0; i < gu1.length; i++) {
			if(!chk[gu1[i]]) return;
		}
		
		q = new LinkedList<Integer>();
		q.offer(gu2[0]);
		chk = new boolean[N+1];
		chk[gu2[0]] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();			for(Integer i : adj[cur]) {
				if(chkin(i, 2) && !chk[i]) {
					q.offer(i);
					chk[i] = true;
				}
			}
		}
		for (int i = 0; i < gu2.length; i++) {
			if(!chk[gu2[i]]) return;
		}
		
		int pop1 = 0, pop2 = 0;
		for (int i = 0; i < gu1.length; i++) {
			pop1 += pop[gu1[i]];
		}
		for (int i = 0; i < gu2.length; i++) {
			pop2 += pop[gu2[i]];
		}
		
		answer = Math.min(answer, Math.abs(pop1 - pop2));		
		
	}
	
	static boolean chkin(int num, int gu) {
		if(gu == 1) {
			for (int i = 0, size = gu1.length; i < size; i++) {
				if(num == gu1[i]) return true;
			}
		}else if(gu == 2) {
			for (int i = 0, size = gu2.length; i < size; i++) {
				if(num == gu2[i]) return true;
			}
		}
		return false;
	}

}
