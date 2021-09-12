import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class atm_bj_11399 {
	
	static int N;
	static int[] time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		time = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		// 인출에 걸리는 시간이 오름차순 정렬대로 인출해야 대기시간이 최소가 됨
		Arrays.sort(time);
		
		int pTime = 0;	// 사람 별 인출하는데 필요한 시간
		int sum = 0;
		for(int i=0; i<N; i++) {
			pTime += time[i];
			sum += pTime;
		}
		
		System.out.println(sum);
	}
	

}
