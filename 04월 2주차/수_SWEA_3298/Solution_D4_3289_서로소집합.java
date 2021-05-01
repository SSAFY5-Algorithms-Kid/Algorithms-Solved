import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *	
 *	<제약사항>
 *	TC가 주어진다
 *	1<= n, m <= 100000
 *	
 *	<풀이>
 *	union-find 를 이용해서
 *	0이면 union을
 *	1이면 union인지 판단을 해서
 *	출력 형식에 맞춰서 stringbuilder를 사용
 *	
 */
public class Solution_D4_3289_서로소집합 {
	
	static int T;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());	// 테케
		
		for (int t = 1; t <= T; t++) {
			
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// 노드 개수
			int m = Integer.parseInt(st.nextToken());	// 연산 횟수
			
			// makeset
			p = new int[n];
			for (int i = 0; i < n; i++) {
				p[i]=i;
			}
			
			//출력준비
			sb.append("#"+t+" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int calc = Integer.parseInt(st.nextToken());	// 연산자
				int a = Integer.parseInt(st.nextToken());		// 노드 번호
				int b = Integer.parseInt(st.nextToken());		// 노드 번호
				if (calc==0) {	// 연산이 0 이면 union
					union(a-1,b-1);
				}else if(calc == 1) {	// 연산이 1이면  같은지 판단한다
					if (isUnioned(a-1,b-1)) {
						sb.append("1");
					}else
						sb.append("0");
				}
			}
			System.out.println(sb);
		}
	}
	static boolean isUnioned(int a, int b) {
		return find(a)==find(b);
	}
	
	static int find(int a) {
		if (p[a]==a) {
			return a;
		}
		return p[a]=find(p[a]);
	}
	
	private static void union(int a, int b) {	
		
		int aroot = find(a);
		int broot = find(b);
		
		if (aroot==broot) {
			return;
		}
		p[broot]=aroot;
	}
}









