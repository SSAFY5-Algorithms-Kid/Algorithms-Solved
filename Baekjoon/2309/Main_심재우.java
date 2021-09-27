import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2309_일곱난쟁이_B2 {

	static int[] p;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		p = new int[9];
		num = new int[7];
		for (int i = 0; i < 9; i++) {
			p[i]=sc.nextInt();
		}
		
		nCr(0,0);
	}
	private static void nCr(int cnt, int start) {
		if (cnt==7) {
			int tot = 0;
			for (int i = 0; i < 7; i++) {
				tot += num[i];
			}
			if (tot==100) {
				Arrays.sort(num);
				for (int i = 0; i < 7; i++) {
					System.out.println(num[i]);
				}
				System.exit(0);
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			
			num[cnt]=p[i];
			nCr(cnt+1, i+1);
		}
	}

}
	