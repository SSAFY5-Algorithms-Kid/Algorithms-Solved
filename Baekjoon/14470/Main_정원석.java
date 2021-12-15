package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No14470_전자레인지 {
	
	static int A, B, C, D, E;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		D = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		if(A < 0) {
			ans += (0 - A) * C + D + B * E;
		}else {
			ans += (B - A) * E;
			if(A == 0) ans += D;
		}
		
		System.out.println(ans);

	}

}
