package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<문제>
 *	R은 뒤집기 D는 제일 앞에 것을 지운다
 *	<제약사항>
 *	첫줄에 TC
 *	함수 p
 *	갯수 n
 *	배열
 *	순으로 입력된다.
 *	<풀이>
 *	R이 나올때마다 배열을 뒤집으면 시간초과가 난다
 *	R이 나오면 배열이 뒤집혔다 생각하고 그다음 D를 어디서 지울지를 판단해주면서 함수를 수행한다
 *	마지막에 R이 뒤집힌 상태인지 원래 상태인지 판단하고
 *	출력해준다.
 *	
 */
public class Main_BOJ_G5_5430_AC {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		a: for (int t = 1; t <= TC; t++) {
			
			char[] p=br.readLine().toCharArray();
			
			int n = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> list = new ArrayList<>();	// 배열을 담을 arraylist
			StringTokenizer st = new StringTokenizer(br.readLine(),"[,]");	// [,]가 나오면 제끼고 st에 담는다
			for (int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				list.add(tmp);
			}
			// 입력완료
			
			boolean flag = false;	// 뒤집힌건지 판단 처음 상태는 false
			for (int i = 0; i < p.length; i++) {
				if (p[i]=='R' && !flag) {	// R이면서 정방
					flag = true;	// 역방
				}else if (p[i]=='R' && flag) {	// R이면서 역방
					flag = false;	// 정방
				}
				if (p[i]=='D') {	// D일때
					if (list.size()==0) {	// size가 0이면 error 출력 후 다음 TC로
						System.out.println("error");
						continue a;
					}
					if (flag) {	// 역방이면 끝에서 하나 빼준다
						list.remove(list.size()-1);	
					}else {	// 정방이면 앞에서 하나 빼준다
						list.remove(0);
					}
				}
			}
			// 출력 형태를 잡아주기 위해 stringbuilder 사용
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if (list.size()!=0) {
				if (flag) {	// 역방이면 뒤에서부터 
					for (int i = 0; i < list.size()-1; i++) {
						sb.append(list.get(list.size()-1-i));
						sb.append(",");
					}
					sb.append(list.get(0));
				}else {	// 정방이면 앞에서부터
					for (int i = 0; i < list.size()-1; i++) {
						sb.append(list.get(i));
						sb.append(",");
					}
					sb.append(list.get(list.size()-1));
				}
			}
			sb.append("]");
			
			//출력
			System.out.println(sb);
		}
	}
}

/*
4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]
	
		
1
RDD
4
[1,2,3,4]

1
DD
2
[1,2]

*/		