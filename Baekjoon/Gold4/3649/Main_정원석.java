package Apr_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_No3649_로봇프로젝트 {
	
	static int x, n, answer = -1;
	static int l1 = -1, l2;
	static int[] chk = new int[200000001];
	static int[] numbers;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = null;
		
		while((tmp = br.readLine()) != null) {
			x = Integer.parseInt(tmp);
			n = Integer.parseInt(br.readLine());
			
			x *= 10000000;
			
			numbers = new int[n];
			
			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(numbers);
			
			int start = 0;
			int end = n - 1;
			boolean flag = false;
			
			while(start < end) {
				if(x == numbers[start] + numbers[end]) {
					System.out.println("yes" + " " + numbers[start] + " " + numbers[end]);
					flag = true;
					break;
				}else if(numbers[start] + numbers[end] > x) end--;
				else start++;
			}
			if(!flag) System.out.println("danger");
		}
		
	}

}

//public class BOJ_No3649_로봇프로젝트 {
//	
//	static int x, n, answer = -1;
//	static int l1, l2;
//	static int[] chk = new int[200000001];
//	static int[] numbers;
//
//	public static void main(String[] args) throws Exception{
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		x = Integer.parseInt(br.readLine());
//		n = Integer.parseInt(br.readLine());
//		
//		x *= 10000000;
//		
//		numbers = new int[n];
//		
//		for (int i = 0; i < n; i++) {
//			numbers[i] = Integer.parseInt(br.readLine());
//			chk[numbers[i]]++;
//		}
//		
//		for (int i = 0; i <= n / 2; i++) {
//			if(chk[numbers[i]] != 0 && chk[x - numbers[i]] != 0) {
//				if(Math.abs(numbers[i] - x) > answer) {
//					answer = Math.abs(numbers[i] - x);
//					l2 = Math.max(numbers[i], x - numbers[i]);
//					l1 = Math.min(numbers[i], x - numbers[i]);
//				}
//			}
//		}
//		
//		if(answer == -1) System.out.println("danger");
//		else System.out.println("yes" + " " + l1 + " " + l2);
//	}
//
//}
