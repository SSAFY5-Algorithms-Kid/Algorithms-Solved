package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2212_센서 {
	
	static int N, K, ans = 0;
	static int[] num, diff;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		if(K >= N) {
			System.out.println(0);
			System.exit(0);
		}
		
		num = new int[N];
		diff = new int[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		for (int i = 1; i < N; i++) {
			diff[i-1] = num[i] - num[i-1];
		}
		
		Arrays.sort(diff);
		
		for (int i = 0; i < N - K; i++) {
			ans += diff[i];
		}
		
		System.out.println(ans);

	}

}
