

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_심재원 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static char[] road;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		String line = input.readLine();
		road = line.toCharArray();
		dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		// B -> O --> J
		if(road[0] != 'B') { //첫자리가 B가 아니면 종료
			System.out.println(-1);
			System.exit(0);
		}
		
		for (int i = 0; i < N; i++) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			for (int j = i+1; j < N; j++) {
				if(road[i] == 'B' && road[j] == 'O')
					dp[j] = (int) Math.min(dp[j], dp[i]+ Math.pow(j-i, 2));
				if(road[i] == 'O' && road[j] == 'J')
					dp[j] = (int) Math.min(dp[j], dp[i]+ Math.pow(j-i, 2));
				if(road[i] == 'J' && road[j] == 'B')
					dp[j] = (int) Math.min(dp[j], dp[i]+ Math.pow(j-i, 2));
			}
		}
		
		if(dp[N-1] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[N-1]);
	}

	static String src = "9\r\n" + 
			"BOJBOJBOJ";
}
