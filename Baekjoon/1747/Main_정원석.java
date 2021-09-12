package Apr_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_No_1747_소수팰린드롬 {
	
	static int N;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int tmp = Integer.parseInt(num);
		
		while(true) {
			
			if(isPalin(tmp)) {
				if(isPrime(tmp)) {
					System.out.println(tmp);
					break;
				}
			}
			tmp++;
		}
		

	}
	
	static boolean isPalin(int num) {
		String str = Integer.toString(num);
		int len = str.length();
		
		for (int i = 0; i < len/2; i++) {
			if(str.charAt(i) != str.charAt(len - i - 1)) return false;
		}
		return true;
	}
	
	static boolean isPrime(int n) {
		
		if(n == 1) return false;
		else if(n == 2) return true;
		
		for (int i = 2; i*i <= n; i++) {
			if(n % i == 0) return false;
		}
		return true;
	}

}
