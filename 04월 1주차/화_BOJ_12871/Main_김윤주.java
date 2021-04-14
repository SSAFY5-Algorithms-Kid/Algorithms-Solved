import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 무한문자열_bj_12871 {
	
	static String s, t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
		
		// 문자열 합치는 순서를 달리하여 비교함
		if((s+t).compareTo((t+s)) == 0)	System.out.println(1);
		else	System.out.println(0);

	}

}
