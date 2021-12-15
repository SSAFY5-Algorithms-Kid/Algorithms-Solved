package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1339_단어수학 {
	
	static int N, answer = 0, num = 9;
	static String[] words;
	static int[] alpha;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		words = new String[N];
		alpha = new int[26];
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		for (int i = 0; i < N; i++) {
			int tmp = (int)Math.pow(10, words[i].length() - 1);
			for (int j = 0, size = words[i].length(); j < size; j++) {
				alpha[words[i].charAt(j) - 65] += tmp;
				tmp /= 10;
			}
		}
		
		Arrays.sort(alpha);
		
		for (int i = 25; i >= 0; i--) {
			if(alpha[i] == 0) break;
			answer += alpha[i] * num;
			num--;
		}
		
		System.out.println(answer);

	}

}
