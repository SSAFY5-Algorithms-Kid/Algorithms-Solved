import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *	답을 long 으로 선언해주자..
 *	곱셈을 해봐!
 */
public class Main_BOJ_16208_귀찮음_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stick = new int[N];
		
		int total = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			stick[i] = a;
			total += a;
		}
		
		Arrays.sort(stick);
		long ans = 0;
		for (int i = 0; i < N; i++) {
			
			ans += stick[i] * (total-stick[i]);
			total -= stick[i];
			
		}
		
		System.out.println(ans);
		
	}

}
