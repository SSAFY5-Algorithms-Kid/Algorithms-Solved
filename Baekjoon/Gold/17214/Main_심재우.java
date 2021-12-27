package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author JAEWOO SHIM
 * @date  
 *
 *	<문제>
 *  적분
 *  <제약사항>
 *  변수는 x, 상수는 W 상수는 10000이 넘지 않는다 계수의 절대값이 1인 경우 1을 생략한다 
 *  <풀이>
 *  각 차수 별로 나누어서 적분을 각각 계산해주었다
 *  +-, 0, 상수만 주어진 경우, 마지막이 n차항인 경우를 생각해주어야한다.
 *  
 */
public class Main_BOJ_G5_17214_다항함수의적분 {

	static Queue<Character> q;	// 각 항을 넣을 queue
	static StringBuilder sb;	// 계산된 다항식을 넣을 곳 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		char[] eq = s.toCharArray();
		
		q = new LinkedList<>();
		sb = new StringBuilder();
		for (int i = 0; i < eq.length; i++) {
			if (eq[i]=='+'||eq[i]=='-') {	// +,- 일때 
				if (i==0) {	// 처음 입력된게 - 이면 
					sb.append(eq[i]);	// sb에 붙여준다
				}else {
					inte();	// 적분계산
					q.clear();	// 계산 후 q를 비워준다
					sb.append(eq[i]);	// +,-를 sb에 붙여준다
				}
			}
			else {
				q.offer(eq[i]);	// +,- 가 나오기 전까지 계속 q에 추가
			}
		}
		if (q.peek()=='0') {	// 입력이 0인 경우 상수만 출력
			sb.append("W");
		}else {	// 앞의 항을 계산하고 남은 제일 뒤의 항
			inte();	// 적분
			sb.append("+W");	// +상수
		}
		
		//출력
		System.out.println(sb);
		
	}

	static void inte() {
		StringBuilder sbn = new StringBuilder();	// 계수용
		StringBuilder sbx = new StringBuilder();	// 변수용
		while (q.peek()!='x') {	// x가 나오기전은 계수이다
			sbn.append(q.poll());	// 계수값을 이어붙인다
			
			if (q.isEmpty()) {	// q가 비었다면 break;
				break;
			}
		}
		int a = Integer.parseInt(sbn.toString());	// 계수
		
		int cnt = 0;	// 차수를 판단
		while(!q.isEmpty()) {	// x가 있으면
			sbx.append(q.poll());	// 붙여주고
			cnt++;	// 차수+1
		}
		
		int na = a/(cnt+1);	// 적분 후 계수
		
		if (na!=1) {	// 1인경우 생략
			sb.append(na); 
		}
		
		for (int i = 0; i <= cnt; i++) {	// x의 개수 +1 만큼 sb에 붙이기
			sb.append("x");
		}
		
	}

}

/*
6x+6

66xx+6x+6

0

16x

16

-3x+2

4x-1

2x+1

*/