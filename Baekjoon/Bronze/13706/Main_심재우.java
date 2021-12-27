package BOJ;

import java.math.BigInteger;
import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  21.03.29
 * <제약사항>
 * 
 * 
 */
public class Main_BOJ_B1_13706_제곱근 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger N = new BigInteger(sc.next());

		BigInteger half = new BigInteger("2");

		BigInteger left = new BigInteger("1");
		BigInteger mid;
		BigInteger right = N;
		BigInteger nn;
		BigInteger lplusr;
		while (true) {
			lplusr = left.add(right);
			mid = lplusr.divide(half);
			nn = mid.multiply(mid);
			if (nn.compareTo(N) < 0) { // n*n이 N보다 작음
				left = mid;
			}
			if (nn.compareTo(N) > 0) {
				right = mid;
			}
			if (nn.compareTo(N) == 0) {
				System.out.println(mid);
				break;
			}

		}
	}

}
