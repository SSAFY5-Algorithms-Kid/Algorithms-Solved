package Apr_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_No5052_전화번호목록 {
	
	static int T, N;
	static String[] num;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new String[N];
			for (int i = 0; i < N; i++) {
				num[i] = br.readLine().replace(" ", "");
			}
			
			Arrays.sort(num);
			
			System.out.println(check() ? "NO" : "YES");
		}

	}
	
	static boolean check() {
		for (int i = 0; i < N - 1; i++) {
			if(num[i+1].startsWith(num[i])) return true;
		}
		return false;
	}

}
