package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No12871_무한문자열 {
	
	static int T;
	static String str1, str2;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			str1 = br.readLine();
			str2 = br.readLine();
			
			int num1 = str1.length();
			int num2 = str2.length();
			
			int s = 2;
			int gcd = 1;
			
			while(s <= num1 && s <= num2) {
				if(num1 % s == 0 && num2 % s == 0) {
					gcd = s;
				}
				s++;
			}
			
			int lcm = num1 * num2 / gcd;
			
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
			for (int i = 1; i <= lcm / num1; i++) {
				sb1.append(str1);
			}
			
			for (int i = 1; i <= lcm / num2; i++) {
				sb2.append(str2);
			}
			
			if(sb1.toString().equals(sb2.toString())) System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + 0);
		}
		
	}

}
