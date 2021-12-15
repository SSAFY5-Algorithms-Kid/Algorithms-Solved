import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N, MAX;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 로프 개수 (1이상 100,000이하)
		MAX = Integer.MIN_VALUE;
		arr = new int[N];

		for (int n = 0; n < N; n++)
			// N개의 로프를 받는다.
			arr[n] = Integer.parseInt(br.readLine());
		
		// 정렬해서 선택 순서를 진행한다.최대 무게를 구해야하니까 지금 선택 * 더 큰 무게를 감당할 수 있는 로프의 수
		Arrays.sort(arr);
		
		// 해당으로 정렬 순으로 계산한다.
		for(int n=0;n<N;n++) 
			MAX = Integer.max(MAX, (arr[n]*(N-n)));
		
		System.out.println(MAX);
	}
}