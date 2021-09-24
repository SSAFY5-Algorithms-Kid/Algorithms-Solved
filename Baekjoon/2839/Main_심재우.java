import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author JAEWOO SHIM
 * @date 21.02.16
 * @algorithm 
 * @version 3
 * Main_BOJ_B1_2839_설탕배달3
 */
// dp
public class Main_BOJ_2839_설탕배달_B1 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] sugar = new int[N+10];	//뒤를 넓게 씀
		Arrays.fill(sugar, 9999);	//전부 다 큰 수로 일단 줌
		sugar[3]=1;
		sugar[5]=1;
		for (int i = 6; i < sugar.length; i++) {
			sugar[i] = Math.min(sugar[i-5], sugar[i-3])+1;
		}
		if (sugar[N]>=9999) {
			System.out.println(-1);
		}else {
			System.out.println(sugar[N]);
		}
		
	}

}
