package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Honeycomb_2292 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 1, MAX = 1, len = 1;

		while (MAX < N) {
			MAX += len++ * 6;
			count++;
		}

		System.out.println(count);
	}
}
