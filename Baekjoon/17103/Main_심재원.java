package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_17103_골드바흐파티션 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, ans;
	static boolean isDecimal = false;
	static boolean[] notDecimal = new boolean[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		//에라토스테네스의 체

		for (int i = 2; i < 1000001; i++) {
			if(notDecimal[i])continue;
			for (int j = i+i; j < 1000001; j+=i) {
				notDecimal[j] = true;
			}
		}
		
		for (int t = 0; t < T; t++) {
			ans = 0;
			N = Integer.parseInt(input.readLine());
			for (int n = 2; n <= N/2; n++) {
				if(!notDecimal[n] && !notDecimal[N-n])ans++;
			}
			System.out.println(ans);
			
			
			
			
		}
	}
	
	static String src = "5\r\n" + 
			"6\r\n" + 
			"8\r\n" + 
			"10\r\n" + 
			"12\r\n" + 
			"100";
}


//package ps.백준.S2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.StringReader;
//import java.util.StringTokenizer;
//
//public class BJ_S2_17103_골드바흐파티션 {
//	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//	static StringBuilder output = new StringBuilder();
//	static StringTokenizer tokens;
//	static int T, N, ans;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
//		T = Integer.parseInt(input.readLine());
//		for (int t = 0; t < T; t++) {
//			N = Integer.parseInt(input.readLine());
//			int A = 0;
//			int B = 0;
//			ans = 0;
//			for (int n = 2; n <= N/2; n++) {
//				boolean isDecimal =  false;
//				A=n;
//				B=N-n;
//				for (int a = 2; a < A; a++) {	// A의 소수 판별
//					if(A%a==0) {
//						isDecimal = true;	//소수면 true
//						break;
//					}
//				}
//				for (int b = 2; b < B; b++) {	// B의 소수 판별
//					if(B%b==0) {
//						isDecimal = true;
//						break;
//					}
//				}
//				if(!isDecimal)ans++;
//				
//			}
//			System.out.println(ans);
//		}
//	}
//	static String src = "5\r\n" + 
//			"6\r\n" + 
//			"8\r\n" + 
//			"10\r\n" + 
//			"12\r\n" + 
//			"100";
//}

