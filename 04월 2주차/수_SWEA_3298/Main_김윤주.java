import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소집합_swea_3289 {
	
	static int T, n, m;
	static int[] parents;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];		// 0 dummy
			make();	// 초기 세팅
			sb.setLength(0);	// sb 초기화
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(op == 0) {
					union(a, b);
				} else {
					if(findSet(a) == findSet(b)) sb.append(1);
					else sb.append(0);
				}
				
			}
			
			System.out.println("#" + t + " " + sb);
		}
	}
	
	static void make() {
		for(int i=1; i<n+1; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA != rootB) parents[rootB] = rootA;
	}

}
