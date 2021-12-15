package BOJ;

import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  
 *	
 *	3으로 먼저 나눠서 최대한 상자에 넣고
 *	그 뒤를 나눠서 넣어준다.
 */
public class Main_BOJ_12981_공포장하기_S5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int G = sc.nextInt();
		int B = sc.nextInt();
		
		int ans = 0;
		ans = (R/3) + (G/3) + (B/3);
		R = R%3;
		G = G%3;
		B = B%3;
		while(true) {
			if (R==0 && G==0 && B==0) {
				break;
			}
			if (R>=1 && G>=1 && B>=1) {
				R-=1;
				G-=1;
				B-=1;
				ans++;
				continue;
			}
			if (R>=1 && G>=1 && B<1) {
				R-=1;
				G-=1;
				ans++;
				continue;
			}
			if (R>=1 && G<1 && B>=1) {
				R-=1;
				B-=1;
				ans++;
				continue;
			}
			if (R<1 && G>=1 && B>=1) {
				G-=1;
				B-=1;
				ans++;
				continue;
			}
			//=====
			if (R>=3 && G<1 && B<1) {
				R-=3;
				ans++;
				continue;
			}
			if (R>=2 && G<1 && B<1) {
				R-=2;
				ans++;
				continue;
			}
			if (R>=1 && G<1 && B<1) {
				R-=1;
				ans++;
				continue;
			}
			//=======
			if (R<1 && G>=3 && B<1) {
				G-=3;
				ans++;
				continue;
			}
			if (R<1 && G>=2 && B<1) {
				G-=2;
				ans++;
				continue;
			}
			if (R<1 && G>=1 && B<1) {
				G-=1;
				ans++;
				continue;
			}
			//========
			if (R<1 && G<1 && B>=3) {
				B-=3;
				ans++;
				continue;
			}
			if (R<1 && G<1 && B>=2) {
				B-=2;
				ans++;
				continue;
			}if (R<1 && G<1 && B>=1) {
				B-=1;
				ans++;
				continue;
			}
			
		}
		System.out.println(ans);
	}

}
