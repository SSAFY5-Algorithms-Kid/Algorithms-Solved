package BOJ;

import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  21.04.05
 * 
 *	중복 조합을 이용한다.
 *
 */
public class Main_BOJ_S3_16922_로마숫자만들기 {

	static int[] p = {1,5,10,50};
	static int r;
	static boolean[] v;	// boolean 배열을 이용해서 해당 수를 만들어 낼 수 있는지 판단한다.
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();	// 4개중에 r개를 중복해서 뽑는다.
		v = new boolean[1001];	// 만들어낼 수 있는 최대의 수는 50 * 20 이므로 배열의 크기를 1001로 잡았다.
		num = new int[r];
		combi(0,0);
		int ans = 0;
		for (int i = 0; i < 1001; i++) {
			if (v[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	/*
	 * 기본적인 조합코드와 똑같이 구현하되
	 * 중복조합은 이미 뽑은 놈도 다시 뽑을 수 있기 때문에
	 * 재귀를 combi(cnt+1, i+1)이 아닌 combi(cnt+1, i)로 돌려주었다.
	 */
	private static void combi(int cnt, int start) {
		if (cnt==r) {
			int tot = 0;
			for (int i = 0; i < r; i++) {
				tot += num[i];
			}
			if (v[tot]) {
				return;
			}
			v[tot]=true;
			return;
		}
		for (int i = start; i < 4; i++) {
			
			num[cnt]=p[i];
			combi(cnt+1, i);
		}
	}

}
