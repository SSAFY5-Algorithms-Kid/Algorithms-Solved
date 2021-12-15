import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, winA, winB;
	static int[] A, B;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			winA = winB = 0;

			A = new int[4];
			B = new int[4];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int n = 0; n < cnt; n++) {
				int idx = Integer.parseInt(st.nextToken()) - 1;
				A[idx]++;
			}

			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());

			for (int n = 0; n < cnt; n++) {
				int idx = Integer.parseInt(st.nextToken()) - 1;
				B[idx]++;
			}

			if (A[3] > B[3])
				System.out.println("A");
			else if (A[3] < B[3])
				System.out.println("B");
			else {
				if (A[2] > B[2])
					System.out.println("A");
				else if (A[2] < B[2])
					System.out.println("B");
				else {
					if(A[1] > B[1])
						System.out.println("A");
					else if(A[1] < B[1])
						System.out.println("B");
					else {
						if(A[0]>B[0])
							System.out.println("A");
						else if(A[0]<B[0])
							System.out.println("B");
						else
							System.out.println("D");
					}
				}
			}
		}
	}
}