package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author JAEWOO SHIM
 * @date  21.04.05
 * <문제>
 * s와 t의 길이는 50보다 작거나 같은 자연수이고 알파벳 소문자로만 이루어져 있다.
 * 
 * abc abca 와 같은 경우 때문에 단순히 반복해서 비교하면 안된다.
 * 
 * 최소공배수 만큼 반복을 돌려주면 된다.
 *
 */
public class Main_BOJ_12871_심재우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] s = br.readLine().toCharArray();
		char[] f = br.readLine().toCharArray();

		boolean flag = true;
		
		int mult = s.length * f.length;
		
		for (int i = 0; i < mult; i++) {
			if (s[i % s.length] != f[i % f.length]) {
				flag = false;
			}
		}
		
//		if (sl%fl==0 || fl%sl==0) {
//			for (int i = 0; i < max; i++) {
//				if (s[i % s.length] != f[i % f.length]) {
//					flag = false;
//				}
//			}
//		}else {
//			int mult = sl*fl;
//			for (int i = 0; i < mult; i++) {
//				if (s[i % s.length] != f[i % f.length]) {
//					flag = false;
//				}
//			}
//		}

		if (flag) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
				
	}

}

