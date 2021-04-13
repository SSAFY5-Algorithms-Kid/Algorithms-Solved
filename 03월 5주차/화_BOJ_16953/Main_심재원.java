

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_심재원 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static long A,B;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens =new StringTokenizer(input.readLine());
		A = Long.parseLong(tokens.nextToken());
		B = Long.parseLong(tokens.nextToken());
		
		int cnt = 1;
		while(B != A) {
			if(B < A) {
				cnt = -1;
				break;
			}
			
			if(B%10 == 1) {
				B/=10;
				cnt++;
			}
			else if(B%2 ==0) {
				B/=2;
				cnt++;
			}
			else {
				cnt = -1;
				break;
			}
		}
		System.out.println(cnt);
	}
	
	static String src = "100 40021";

}
