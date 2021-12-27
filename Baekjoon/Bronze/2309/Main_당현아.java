import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N = 9, M = 7;
	static int[] person, target;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("BOJ.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		person = new int[N];
		target = new int[M];

		for (int i = 0; i < N; i++)
			person[i] = Integer.parseInt(br.readLine());

		Arrays.sort(person);

		combination(0, 0);
		
		System.out.println(sb.toString());
	}

	private static void combination(int idx, int cnt) {
		if (cnt == M) {
			int sum = 0;
			for (int value : target) {
				sum += value;
			}

			if (sum == 100 && sb.length() == 0) {
				for (int value : target) {
					sb.append(value).append("\n");
				}
			}
			return;
		}

		for (int i = idx; i < N; i++) {
			target[cnt] = person[i];
			combination(i + 1, cnt + 1);
		}

	}
}