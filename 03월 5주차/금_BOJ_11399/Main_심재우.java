package BOJ;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<문제>
 *	N명이 각각 뽑는데 걸리는 시간이 p[i]이다
 *	N명이 다 뽑는데 걸리는 시간을 구해라.
 *	<제약사항>
 *	1<= N <= 1000
 *	1 <= p <= 1000
 *	<풀이>
 *	각 값의 최소가 되려면 시간값을 작은 순으로 정렬해서 각각을 더한 값을
 *	답에 더해준다.
 */
public class Main_BOJ_S3_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] atm = new int[N];
		for (int i = 0; i < N; i++) {
			atm[i]=sc.nextInt();
		}
		Arrays.sort(atm);
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < i; j++) {
				tmp+=atm[j];
			}
			ans+=atm[i]+tmp;
		}
		System.out.println(ans);
	}

}
