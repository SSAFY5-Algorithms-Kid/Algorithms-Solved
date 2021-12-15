package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MelodyCopyright_2914 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int singNum = Integer.parseInt(st.nextToken());
		int avg = Integer.parseInt(st.nextToken());

		System.out.println(singNum * (avg - 1) + 1);
	}
}
