package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_B1_13706_제곱근 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static String n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = input.readLine();
		BigInteger val = new BigInteger(n);
		BigInteger left = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger right = val;
		BigInteger mid = null;
		
		while(left.compareTo(right) < 0) {
			mid = left.add(right).divide(two);
			BigInteger tmp = mid.pow(2);
			if(val.compareTo(tmp) == 0) {
				break;
			}
			
			else if(val.compareTo(tmp) > 0) left = mid;
			else right = mid;
		}
		
		System.out.println(mid);
	}

}
