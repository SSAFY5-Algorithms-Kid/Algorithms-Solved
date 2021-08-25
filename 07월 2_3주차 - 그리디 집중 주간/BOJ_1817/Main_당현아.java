import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M; // 책의 개수(0이상), 최대 무게
	static int Result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int weight = 0;
		if (N > 0) // 책의 개수가 0도 가능
			st = new StringTokenizer(br.readLine());
		
		for (int n = 0; n < N; n++) {
			int now = Integer.parseInt(st.nextToken());

			if (weight + now > M) {
				// 최대 무게를 넘으면, 지금 값으로 바꾸고 카운트
				weight = now;
				Result++;
			} else if (weight + now == M) {
				// 최대무게랑 같으면, 초기화 후 카운트
				weight = 0;
				Result++;
			} else {
				// 최대무게 안넘으면, 그냥 더하기
				weight += now;
			}
		}

		// 계산이 끝났는데 0이 아니면 1상자가 더 있음
		if (weight > 0)
			Result++;

		System.out.println(Result);
	}
}
