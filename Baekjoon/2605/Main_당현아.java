import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer("");

		N = Integer.parseInt(br.readLine());
		list = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(n - num < 0 ? 0 : n - num, n + 1);
		}

		for (int i = 0; i < N; i++) {
			sb.append(list.get(i));
			if (i < N - 1) {
				sb.append(" ");
			}
		}

		System.out.println(sb.toString());
	}
}