import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1817_짐챙기는숌_S4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if (N==0) {
			System.out.println("0");
			System.exit(0);
		}
		int[] book = new int[N];
		
		int tmp =0;
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int weight = Integer.parseInt(st.nextToken());
			
			tmp += weight;
			if (tmp == M) {
				tmp=0;
				ans++;
			}
			if (tmp>M) {
				ans++;
				tmp = weight;
			}
			
		}
		if (tmp!=0) {
			ans++;
		}
		System.out.println(ans);
		
	}

}

/*

2 2
1 2



*/