package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class addEachLine_2558 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		num += Integer.parseInt(br.readLine());

		System.out.println(num);
	}
}
