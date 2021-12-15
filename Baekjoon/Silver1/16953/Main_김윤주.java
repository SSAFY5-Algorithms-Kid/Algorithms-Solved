import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김윤주 {
	
	static int A, B, cnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		op(A, 1);
		
		if(cnt == Integer.MAX_VALUE)	System.out.println(-1);
		else	System.out.println(cnt);
	}
	
	// A, B가 10^9라서 int 범위 내에 계산이 가능하다고 생각했는데 1을 수의 가장 오른쪽에 추가하면 int의 범위를 넘는 경우가 생긴다.
	static void op(long a, int count) {
		if(a == B) {
			cnt = Math.min(cnt, count);
			return;
		}
		
		if(a > B)	return;
		
		op(a*2, count+1);
		op(a*10 + 1, count+1);
	}

}
