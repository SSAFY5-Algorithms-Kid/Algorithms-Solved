package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541_잃어버린괄호 {
	
	static int ans;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 방법 1) 한번 '-' 나온 이후로는 모두 뺄셈 해주면 됨
//		String input = br.readLine();
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i=0; i<input.length(); i++) {
//			if(input.charAt(i)=='-' || input.charAt(i)=='+') {
//				if(flag) {
//					ans -= Integer.parseInt(sb.toString());
//				} else {
//					ans += Integer.parseInt(sb.toString());
//					if(input.charAt(i)=='-') flag = true;
//				}
//				sb.setLength(0);
//			} 
//			else {
//				sb.append(input.charAt(i));
//			}
//		}
//		
//		if(flag) ans -= Integer.parseInt(sb.toString());
//		else ans += Integer.parseInt(sb.toString());
		
		
		
		// 방법 2) -로 나눠서 연산
		// 참고 https://st-lab.tistory.com/148
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			while(st2.hasMoreTokens()) {
				temp += Integer.parseInt(st2.nextToken());
			}
			
			// 처음 연산은 무조건 양수(덧셈)이므로 flag를 통해 첫번째인지 체크 
			// 첫번째 연산을 제외한 nextToken은 뺄셈
			if(!flag) {
				ans += temp;
				flag = true;
			} else ans -= temp;
		}
		
		System.out.println(ans);
		
	}
	
	

}
