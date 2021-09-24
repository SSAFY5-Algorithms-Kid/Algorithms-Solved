import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<문제>
 *	배열을 주면 그 배열 내의 값들을 더하거나 빼서
 *	target이 되게끔 하는 경우의 수를 구한다.
 *	<풀이>
 *	완탐
 */
public class Solution_타겟넘버 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i]=sc.nextInt();
		}
		int target = sc.nextInt();
		
		int answer = 0;
        size = numbers.length;
        arr = numbers;
        cnt = 0;
        T = target;
        dfs(0,0);
        answer = cnt;
        System.out.println(answer);
	}
	static int size;
	static int[] arr;
	static int T;
	static int cnt;
	static void dfs(int num, int idx) {
		if (idx >= size) {
			if(num==T) {
				cnt++;
				return;
			}
			return;
		}
		int s1 = num + arr[idx];
		dfs(s1, idx+1);
		int s2 = num - arr[idx];
		dfs(s2, idx+1);
	}
}

/*
5
1 1 1 1 1
3

*/