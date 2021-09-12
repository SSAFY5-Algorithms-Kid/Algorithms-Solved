package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author JAEWOO SHIM
 * @date  21.04.01
 *	
 *	<문제>
 *	짝수 N 이 주어지고 그 N이 두 소수의 합으로 표현될 때 몇가지가 나오나?
 *	<제약사항>
 *	첫째줄에 TC가 주어진다 1<= TC <= 100
 *	N은 짝수이고 2 < N <= 1,000,000
 *	N은 한줄에 하나씩 입력된다.
 *	두 소수의 순서만 다른 것은 같은 파티션으로 취급한다.
 *	<풀이>
 *	(에라토스테네스의 체)를 이용한다.
 *	소수를 구해놓고 두개를 더해서 T가 되는 경우를 카운트한다.
 *	
 */
public class Main_BOJ_S2_17103_골드파흐파티션 {

	public static void main(String[] args) throws IOException {
		
		//에라토스테네스의 체
		int MAX = 1000000;
		boolean[] check = new boolean[MAX+1];
		ArrayList<Integer> prime = new ArrayList<>();
		for (int i = 2; i <= MAX; i++) {
			if (!check[i]) {
				prime.add(i);
				for (int j = i+i ; j <= MAX; j+=i) {
					check[j]=true;
				}
			}
		}	
		// prime에는 소수만 들어있다.
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			
			int ans = 0;
			for (int x : prime) {
				int y = N-x;
				if (x<=y && !check[y]) {
					ans++;
				}
			}
			// prime을 쓰지 않아도 풀 수 있음
//			for (int i = 2; i <= N/2; i++) {
//				if (!check[i] && !check[N-i]) {
//					ans++;
//				}
//			}
			
			System.out.println(ans);
		}
	}
}
