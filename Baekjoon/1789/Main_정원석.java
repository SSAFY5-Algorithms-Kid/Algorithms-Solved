package May_2;

import java.util.Scanner;

public class BOJ_No1789_수들의합 {
	
	static int answer = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		
		int chk = 1;
		while(true) {
			answer++;
			if(chk > num / 2) break;
			else if(chk == num / 2 && num % 2 == 0) break;
			num -= chk;
			chk++;			
		}
		System.out.println(answer);

	}

}
