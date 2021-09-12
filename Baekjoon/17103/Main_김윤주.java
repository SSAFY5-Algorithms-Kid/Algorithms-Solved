import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_김윤주 {
	
	static int T, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		// 에라토스테네스의 체 false가 소수
		boolean[] eratos = new boolean[1000001];
		for(int i=2; i<1000001; i++) {
			// i의 배수를 소수가 아니라고 마킹해줌(true)
			for(int j=i+i; j<1000001; j+=i) {
				eratos[j] = true;
			}
		}
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			// N/2가 넘으면 (i, N-i)짝의 순서만 바뀌므로 N/2까지만 탐색
			for(int i=2; i<=N/2; i++) {
				// i와 N-i가 모두 소수이면 cnt++
				if(!eratos[i] && !eratos[N-i])	cnt++;
			}
			
			System.out.println(cnt);
		}
	}

}
