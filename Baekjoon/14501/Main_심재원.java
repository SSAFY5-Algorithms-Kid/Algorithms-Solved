package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_14501_퇴사 {
	static class Day{
		int time, cost;
		public Day(int time, int cost) {
			this.time = time;
			this.cost = cost;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		Day[] days = new Day[N];
		dp = new int[N+1];
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			days[n] = new Day(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
		}
		
		for(int n=0; n<N;n++) {
			if(isIn(n+days[n].time)) {
				dp[n+days[n].time] = Math.max(dp[n + days[n].time], dp[n]+days[n].cost);
			}
			dp[n+1] = Math.max(dp[n+1], dp[n]);
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
		
	}
	private static boolean isIn(int i) {
		return i<=N;
	}
	static String src = "10\n" + 
			"1 1\n" + 
			"1 2\n" + 
			"1 3\n" + 
			"1 4\n" + 
			"1 5\n" + 
			"1 6\n" + 
			"1 7\n" + 
			"1 8\n" + 
			"1 9\n" + 
			"1 10";
}
