import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] grid;
	static int answer = Integer.MAX_VALUE;
	static int[] tgt;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		grid = new int[N][N];
		tgt = new int[N/2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		
		System.out.println(answer);
	}
	
	static void comb(int tgtind, int srcind) {
		if(tgtind == N/2) {
			check();
			return;
		}
		
		if(srcind == N) return;
		
		comb(tgtind, srcind+1);
		tgt[tgtind] = srcind;
		comb(tgtind+1, srcind+1);
	}
	
	static void check() {
		int star = 0, link = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(valid(i) && valid(j)) star += grid[i][j];
				else if(!valid(i) && !valid(j)) link += grid[i][j];
			}
		}
		answer = Math.min(answer, Math.abs(star - link));
	}
	
	static boolean valid(int a) {
		for (int i = 0; i < N/2; i++) {
			if(a == tgt[i]) return true;
		}
		return false;
	}

}
