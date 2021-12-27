import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무건너뛰기_bj_11497 {
	
	static int T, N, min;
	static int[] logs, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			logs = new int[N];
			result = new int[N];
			min = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) logs[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(logs);
			find();
			
			System.out.println(min);
		}
		

	}
	
	// 최적의 통나무 배열 찾는 법 => 높이가 낮은 통나무를 양 끝에서부터 배열한다.
	static void find() {
		
		int start = 0;
		int end = N-1;
		
		int idx = 0;
		while(idx < N) {	// 오름차순으로 정렬된 통나무 idx가 짝수면 왼쪽 끝, 홀수면 오른쪽 끝에서부터 정렬
			if(idx%2==0) result[start++] = logs[idx++];
			else result[end--] = logs[idx++];
		}
		
		for(int i=0; i<N; i++) {
			min = Math.max(min, Math.abs(result[i] - result[(i+1)%N]));
		}
	}

}
