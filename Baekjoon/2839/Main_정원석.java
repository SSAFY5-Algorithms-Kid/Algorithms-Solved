import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		answer += N / 5;
		N = N % 5;
//		answer += N / 3;
//		N = N % 3;
		
		if(N == 0) {
			System.out.println(answer);
		}else {
			while(N % 3 != 0) {
				N += 5;
				answer--;
				if(answer < 0) {
					answer = -1;
					break;
				}
			}
			
			if(answer != -1) answer += (N / 3);
			System.out.println(answer);
		}
				
	}

}
