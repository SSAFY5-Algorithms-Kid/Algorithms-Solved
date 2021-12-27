import java.math.BigInteger;
import java.util.*;

public class Main_13706 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputNum = sc.nextLine();
		BigInteger temp = new BigInteger(inputNum);
		BigInteger two = new BigInteger("2");
		BigInteger one = BigInteger.ONE;
		BigInteger res = BigInteger.ZERO;
		BigInteger tempMul = BigInteger.ZERO;
		BigInteger zero = BigInteger.ZERO;
		BigInteger tempCopy = temp;
		while(true) {
			res = (zero.add(tempCopy)).divide(two);
			tempMul = res.multiply(res);
			if(tempMul.compareTo(temp)==0) {
				System.out.println(res);
				break;
			}else if(tempMul.compareTo(temp)>0) {
				tempCopy = res;
			}else {
				zero = res;
			}	
		}
	}
}
