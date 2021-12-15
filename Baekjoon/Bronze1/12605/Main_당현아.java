import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<String> str;
	static int N;
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = new Stack<String>();
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0;i<N;i++) {
			sb.append("Case #").append(i+1).append(": ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while(st.countTokens()>0) {
				str.push(st.nextToken());
			}
			
			while(!str.isEmpty()) {
				sb.append(str.pop()).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}