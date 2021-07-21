import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, S, R;
	static int[] log;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		log = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int s = 0; s < S; s++) {
			log[Integer.parseInt(st.nextToken())] = -1;
		}

		st = new StringTokenizer(br.readLine());
		for (int r = 0; r < R; r++) {
			int now = Integer.parseInt(st.nextToken());

			if (now / 2 > N / 2) {
				if (now + 1 <= N && log[now + 1] == -1)
					log[now + 1] = 0;
				else if (now - 1 >= 0 && log[now - 1] == -1)
					log[now - 1] = 0;
			} else {
				if (now - 1 >= 0 && log[now - 1] == -1)
					log[now - 1] = 0;
				else if (now + 1 <= N && log[now + 1] == -1)
					log[now + 1] = 0;
			}
		}

		int result = 0;
		for (int i = 1; i <= N; i++)
			if (log[i] == -1)
				result++;

		System.out.println(result);
	}
}