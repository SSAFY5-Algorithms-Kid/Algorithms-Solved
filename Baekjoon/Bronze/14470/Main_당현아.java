import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine()); // 현재 온도
		int B = Integer.parseInt(br.readLine()); // 목표 온도 (B < A)
		int C = Integer.parseInt(br.readLine()); // 냉동 시 1도 올리는 시간
		int D = Integer.parseInt(br.readLine()); // 냉동을 해당하는데 걸리는 시간
		int E = Integer.parseInt(br.readLine()); // 해동 시 1도 올리는 시간
		
		int SUM = 0;
		
		if(A<0) {
			SUM += Math.abs(A)*C;
			SUM += D;
			SUM += B*E;
		}else if (A==0) {
			SUM += D;
			SUM += B*E;
		}else {
			SUM += (B-A)*E;
		}
		
		System.out.println(SUM);
	}
}