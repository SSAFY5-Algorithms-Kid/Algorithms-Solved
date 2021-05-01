package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/**
 * @author JAEWOO SHIM
 * @date  
 *	
 *	<문제>
 *	전화번호가 주어진다.
 *	번호가 중복이 되는지를 판단해라 인데
 *	앞에서부터 같은게 있으면 일관성이 없는것.
 *	911
 *	91125426 이면 911을 눌렀을때 911@@@@@@~ 인 번호는 걸수가 없음
 *	<제약조건>
 *	첫줄에 TC 1~50
 *	전화번호 수 n 1~10000
 *	전화번호는 길어야 10자리이다
 *	전화번호가 같은 경우는 없다
 *	<풀이>
 *	처음엔 String[][]로 각 번호를 다 받아와서 for-for문으로 탐색을 했는데 시간초과.
 *	시간을 줄이기 위해서 String[]만 받고 정렬을 이용해서 짧은순으로 탐색 시간초과.
 *	답이 없어서 검색 -> startsWith를 이용
 *	str2.startsWith(str1)
 *	str2가 str1로 시작하면 true 아니면 false를 return;
 *	자매품 endsWith도 있음 얘는 접미어를 판단.
 *	
 */
public class Main_BOJ_G4_5052_전화번호목록 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// TC
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			// 전화번호를 그대로 받아온다.
			String[] address = new String[n];
			for (int i = 0; i < n; i++) {
				address[i]=br.readLine();
			}
			//==== 입력완료
			
			// 전화번호를 정렬
			Arrays.sort(address, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			
			boolean flag = true;	// 일관성 판단
			for (int i = 0; i < n-1; i++) {
				if (address[i+1].startsWith(address[i])) {	// 접두어 확인
					flag=false;
				}
			}
			
			//==== 출력
			if (flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
	}

}




/*
2
3
911
97625999
91125426
5
113
12340
123440
12345
98346

*/


