import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int area = Integer.parseInt(st.nextToken());

		int[] data = new int[5];
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 5; i++) {
			data[i] = Integer.parseInt(st.nextToken()) - num * area;
			sb.append(data[i]);
			
			if(i<4)
				sb.append(" ");
		}
		
		System.out.println(sb);
		
	}
}