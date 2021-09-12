import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_김윤주 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());
		
		// 0의 제곱근은 그냥 0
		if(N.equals(BigInteger.ZERO))	System.out.println(0);
		else {
			
			// N의 자릿수가 홀수일 경우는 자리수/2+1
			int len = N.toString().length()%2==0 ? N.toString().length()/2 : N.toString().length()/2+1;
			
			BigInteger min, max;
			
			min = BigInteger.TEN.pow(len-1);
			max = min.multiply(BigInteger.TEN);
			
			BigInteger two = new BigInteger("2");
			
			BigInteger mid;
			boolean find = false;
			
			while(!find) {
				mid = min.add(max).divide(two);
				
				if(min.pow(2).equals(N)) {
					System.out.println(min);
					find = true;
				} else {
					
					switch(N.compareTo(mid.pow(2))) {
					case -1:	// N이 min의 제곱 이상 mid제곱 이하일 때
						max = mid;
						break;
					case 0:
						System.out.println(mid);
						find = true;
						break;
					case 1:		// N이 mid의 제곱 이상일 때
						min = mid;
						break;
					}
				}
				
			}
		}
		
	}
}
