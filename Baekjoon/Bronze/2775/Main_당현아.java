package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ApartmentResident_2775 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());

			int[] pre = new int[N + 1];

			for (int i = 1; i <= N; i++)
				pre[i] = i;

			int[] now = new int[N + 1];

			for (int i = 1; i <= K; i++) {

				for (int idx = 1; idx <= N; idx++) {
					int temp = 0;

					for (int j = 1; j <= idx; j++)
						temp += pre[j];

					now[idx] = temp;
				}

				for (int idx = 1; idx <= N; idx++)
					pre[idx] = now[idx];
			}

			System.out.println(pre[N]);
		}
	}
}
