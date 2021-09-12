package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VerigyNumber_2475 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int sum = 0;
		for (int i = 0; i < 5; i++)
			sum += Math.pow(Integer.parseInt(st.nextToken()),2);
		sum = sum % 10;

		System.out.println(sum);
	}
}
