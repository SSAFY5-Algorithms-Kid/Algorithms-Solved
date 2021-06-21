package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sub_1001 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = Integer.parseInt(st.nextToken());
		sum -= Integer.parseInt(st.nextToken());
		
		System.out.println(sum);
	}
}
