package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author JAEWOO SHIM
 * @date  21.04.15
 *	<문제>
 *	숫자와 연산자가 주어지면
 *	숫자와 연산자를 조합해서 최대와 최소를 찾는다
 *	<제약사항>
 *	숫자의 개수 N은 3이상 12이하의 정수
 *	연산자는 항상 N-1
 *	주어진 연산자를 모두 사용해야함
 *	숫자는 1~9
 *	숫자와 숫자 사이에는 연산자가 반드시 1개만
 *	완성된 수식을 계산할 때는 우선순위 없이 왼쪽에서 오른쪽으로 계산
 *	나눗셈의 소수점 이하는 버린다
 *	숫자의 순서는 고정이다
 *	연산 중의 값은 +-1억 이하이다.
 *	<입력>
 *	TC
 *	N 숫자의 개수
 *  각 연산자의 갯수 @ @ @ @ + - * '/'
 *  N개의 숫자가 공백을 두고 주어진다.
 *  <출력>
 *  최대값과 최소값의 차이를 구한다.
 *  
 *  < 처음에 순열로 푸니 중복인 부분이 발생해서 시간초과가 나옴
 *  그래서 중복을 거를 수 있는 np를 이용하면 시간초과가 나오지 않는다
 */
public class Solution_모의_4008_숫자만들기_np {

	static int N;
	static int[] oper;
	static int[] num;
	static int[] noper;
	static boolean[] v;
	static int max, min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());

			int[] tempoper = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				tempoper[i] = Integer.parseInt(st.nextToken());
			}
			oper = new int[N - 1];	// +=1 -=2 *=3 /=4
//			noper = new int[N-1];
			v = new boolean[N-1];
			
			// 연산자 배열 +=1 -=2 *=3 /=4
			int idx = 0;
			for (int i = 0; i < tempoper.length; i++) {
				while(tempoper[i]>0) {
					oper[idx]=i+1;
					idx++;
					tempoper[i]--;
				}
			}
			// 숫자 배열
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			// min max 초기화
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			do {
				max = Math.max(max, calc());
				min = Math.min(min, calc());
			} while (np(oper.length-1));
			
			System.out.println("#"+t+" "+(max-min));

		}

	}
	
	// next permutation 
	private static boolean np(int size) {
		int i = size;
		while (i > 0 && oper[i - 1] >= oper[i])
			i--;
		if (i == 0)
			return false;
		
		int j = size;
		while (oper[i - 1] >= oper[j])
			j--;
		int temp = oper[i - 1];
		oper[i - 1] = oper[j];
		oper[j] = temp;
		
		int k = size;
		while (i < k) {
			temp = oper[i];
			oper[i] = oper[k];
			oper[k] = temp;
			i++;
			k--;
		}

		return true;
	}
	
	// 연산자 종류별로 계산!
	static int calc() {
		int sum = num[0];
		for (int i = 0; i < N-1; i++) {
			if (oper[i]==1) {
				sum += num[i+1];
			}else if (oper[i]==2) {
				sum -= num[i+1];
			}else if (oper[i]==3) {
				sum *= num[i+1];
			}else if (oper[i]==4) {
				sum /= num[i+1];
			}
		}
		return sum;
	}
}

/*
1
5
2 1 0 1
3 5 3 7 9

24

1
6
4 1 0 0
1 2 3 4 5 6 

8

1
5
1 1 1 1
9 9 9 9 9 

144
*/

