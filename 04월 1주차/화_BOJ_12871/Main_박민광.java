import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String a = bf.readLine(); 
		String b = bf.readLine();
		//여기까지 입력값 
		int c = a.length(); 
		int d = b.length();
		//문자열 길이 입력 
		int lcm = c * d / BigInteger.valueOf(c).gcd(BigInteger.valueOf(d)).intValue();
		//gcd 구현으로도 풀었는데, BigInteger 안에 gcd 최대공약수 함수가 있어서 사용해봤씁다.
		
		StringBuilder e = new StringBuilder(a);
		StringBuilder f = new StringBuilder(b);
		//처음에 그냥 string으로 무작정 더해주는 방식으로도 구현을 했는데, 메모리 초과가 나서 StringBuilder 쓰고 통과했어요.
		
		for(int i = 1; i < lcm/c; i++) {
			e.append(a);
		}
		for(int i = 1; i < lcm/d; i++) {
			f.append(b);
		}
		
		if(e.toString().equals(f.toString()))System.out.println(1);
		//StringBuilder는 그냥 equals로 비교가 안되고, toString 으로 String 인스턴스화 해야한대요.
		else System.out.println(0);
   }
}