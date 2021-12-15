package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *
 *	센서를 거리 순으로 정렬
 *	기지국이 2개면 가장 먼 거리 1개를 뺄 수 있고
 *  기지국이 3개면 가장 먼 거리 2개를 뺄 수 있다.
 *  
 */
public class Main_BOJ_2212_센서_G5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());	
		int[] sensor = new int[N];
		for (int i = 0; i < N; i++) {
			sensor[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensor);
		int[] dist = new int[N-1];
		for (int i = 0; i < N-1; i++) {
			dist[i]=sensor[i+1]-sensor[i];
		}
		
		Arrays.sort(dist);
		
		int ans = 0;
		for (int i = 0; i < N-K; i++) {
			ans += dist[i];
		}
		System.out.println(ans);
	}

}
