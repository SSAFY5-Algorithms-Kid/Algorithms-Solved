package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<문제>
 *	N개의 카드를 사려고 할때 가장 비싸게 구매하는 금액을 구하여라
 *	<제약사항>
 *	N 1~1000
 *	p 1~10000
 *	어차피 p가 1000이 넘어가면 성립이 불가능
 * 	<풀이>
 * 	처음에는 앞에서부터 배수인 경우, 합이 되는 경우마다 값을 갱신해줬는데
 * 	중간에 빠지는 부분이 있어서 답을 찾아보고 풀었음
 * 	N개의 카드를 사고 싶을때 N개의 카드를 한번에 사는 경우와 N-i개와 i개의 카드를 구매하는 경우 두가지로 나뉜다
 * 	
 */
public class Main_BOJ_S1_11052_카드구매하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] pack = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			pack[i]=Integer.parseInt(st.nextToken());
		}
		
		// 입력 완료
		
		// 인덱스의 합이 N이 될때..
		
		int[] price = new int[N+1];
		
		for (int i = 1; i < price.length; i++) {
			for (int j = 1; j <= i; j++) {
				price[i]=Math.max(price[i], price[i-j]+pack[j]);
			}
		}
		System.out.println(price[N]);
		
		
		
	}

}

/*
7
742 3302 5186 6619 567 5068 8591

11805

*/