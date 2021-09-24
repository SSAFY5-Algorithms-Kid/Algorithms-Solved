import java.util.Scanner;

public class Main_BOJ_14470_전자레인지_B4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();	// 처음 고기의 온도
		int B = sc.nextInt();	// 목표 온도
		int C = sc.nextInt();	// 얼어있는 고기를 1도 데우는데 걸리는 시간
		int D = sc.nextInt();	// 얼어있는 고기를 해동하는데 걸리는 시간
		int E = sc.nextInt();	// 얼어있지 않은 고기를 1도 데우는데 걸리는 시간
		
		int ans = 0;
		int now = A;
		
		if (A<0) {
			ans += D;
		}
		
		while(now<0) {
			now += 1;
			ans += C;
		}
		
		while(now<B) {
			now +=1;
			ans +=E;
		}
		System.out.println(ans);
		
		
	}

}
