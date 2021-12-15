

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
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		int[] line = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			line[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(line);
		//System.out.println(Arrays.toString(line));
		
		int sum = 0;
		for (int n = 0; n < line.length; n++) {
			int tmp = 0;
			for (int i = 0; i <= n; i++) {
				tmp += line[i];
			}
			//System.out.println(tmp);
			sum += tmp;
		}
		System.out.println(sum);
	}
	static String src = "5\r\n" + 
			"3 1 4 3 2";
}
