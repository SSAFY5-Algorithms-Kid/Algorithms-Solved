package BOJ;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  
 *
 *	<문제>
 *	어떤 수가 대칭일 때 팰린드롬 수라고 한다.
 *	N이 입력으로 주어질 때
 *	N보다 크거나 같고 소수이면서 팰린드롬인 수 중에서
 *	가장 작은 수를 구하라
 *	<제약조건>
 *	1<= N <= 1,000,000
 *	N의 최대값이 1,000,000 이므로 N의 최대값일때 나오는 맥시멈 답은 1,003,001 이다.
 *
 *	에라토스테네스의 체를 이용해서 소수를 구해나가고
 *	팰린드롬 수 인지를 판별하여 그 수가 N보다 크면 답으로 리턴한다.
 *
 */
public class BOJ_1747_심재우 {

	static int ans;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 얘보다 크거나 같아야한다.
		
		prime(N);
		System.out.println(ans);
		
	}

	// 에라토스테네스의 체
	static void prime(int n) {
		int MAX = 1003001; // 최대로 나올 수 있는 답은 1003001이다.
		boolean[] check = new boolean[MAX + 1];
		for (int i = 2; i<=MAX ; i++) {
			if (!check[i]) {
				if (pel(i) && i>=n) {	// 팰린드롬 수 인지 판단하고 N보다 크면 답
					ans = i;
					return;
				}
				for (int j = i + i; j <= MAX; j += i) {
					check[j] = true;
				}
			}
		}
	}
	
	// 0 1 2 3 4 5
	// 0 5 1 4 2 3
	// 0 1 2 3 4 5 6  size = 7
	// 06 15 24
	// 팰린드롬 구하기
	static boolean pel(int p) {
		String s = Integer.toString(p);
		String[] ss = s.split("");
		int size = ss.length;
		boolean flag = true;
		for (int i = 0; i < size/2; i++) {
			if (!ss[i].equals(ss[size-1-i])) {
				flag = false;
			}
		}
		return flag;
	}
}



