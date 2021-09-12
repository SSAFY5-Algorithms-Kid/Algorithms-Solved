package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class add_1000 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0, n = st.countTokens();
		
		for(int i=0;i<n;i++)
			sum+=Integer.parseInt(st.nextToken());
		
		System.out.println(sum);

	}
}
