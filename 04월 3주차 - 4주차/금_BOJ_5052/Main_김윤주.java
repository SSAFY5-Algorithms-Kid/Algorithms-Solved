import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전화번호목록_bj_5052 {
	
	static int T, N;
	static boolean flag;
	static String[] phone;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			phone = new String[N];
			flag = false;
			
			for(int i=0; i<N; i++) {
				phone[i] = br.readLine();
			}
			
			// String으로 입력받은 전화번호 정렬
			Arrays.sort(phone);
			
			for(int i=1; i<N; i++) {
				// i-1번째 전화번호가 i번째 번화번호보다 길이가 길다면 접두어일 수 없으므로 continue
				if(phone[i-1].length() > phone[i].length()) continue;
				
				// i번째 전화번호가 i-1번째 전화번호로 시작하면 일관성 없으므로 flag를 true로 마킹 후 for문 탈출
				if(phone[i].startsWith(phone[i-1])) {
					flag = true;
					break;
				}
				
//				String tmp = phone[i].substring(0, phone[i-1].length());
//				if(phone[i-1].equals(tmp)) {
//					flag = true;
//					break;
//				}
			}
			
			// flag가 true면 일관성 없으므로 no
			sb.append(flag ? "NO\n" : "YES\n");
			
		}
		
		System.out.print(sb);
	}

}
