package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ_S3_16922_로마숫자만들기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, cnt;
	static int[] roma = { 1, 5, 10, 50 };
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		visited = new boolean[1001];

		Combination(N, 0, 0);
		System.out.println(cnt);
	}
/*첫번째 코드
 
	private static void Combination(int toChoose, int sum) {
		if (toChoose == 0) {
			if (!visited[sum]) {
				cnt++;
				visited[sum] = true;
			}
			return;
		}
		for (int i = 0; i < roma.length; i++) {
			int res = sum + roma[i];
			Combination(toChoose - 1, res);
		}
	}
*/
	private static void Combination(int toChoose, int sum, int idx) {

		if (toChoose == 0) {
			if (!visited[sum]) {
				visited[sum] = true;
				cnt++;
			}
			return;
		}
		for (int i = idx; i < roma.length; i++) {
			int res = sum + roma[i];
			Combination(toChoose - 1, res, i);
		}
	}
}
