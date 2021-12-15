import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<문제>
 *	서로다른 N개의 자연수의 합이 S 일때
 *	S를 줄테니 N개가 최대가 되는 값을 구하라
 *	<제약사항>
 *	S : 1 ~ 4,294,967,295
 *	42억이라 long으로 잡았다
 *	<풀이>
 *	가장 많으려면 가장 작은 자연수들을 더해나가면 된다
 *	1부터 순차적으로 더해나가다가 값이 딱 떨어지면 그대로
 *	값이 나갔다면 cnt-- 를 해주면 개수가 나온다.
 *
 */
public class Main_BOJ_1789_수들의합_S5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long S = sc.nextLong();
		// 입력 완료
		
		long n = 0;	// 자연수 n
		long sum = 0;	// 합
		int cnt = 0;	// 갯수
		while(true) {	// S보다 크거나 같아질때까지 더한다
			if (sum>=S) {
				if (sum==S) {
					break;
				}else if(sum>S) {
					cnt--;
					break;
				}
			}
			n++;
			sum+=n;
			cnt++;
		}
		
		// 출력
		System.out.println(cnt);
	}

}
