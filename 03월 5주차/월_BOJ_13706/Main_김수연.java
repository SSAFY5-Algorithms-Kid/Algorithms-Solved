import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_김수연 {
	/*
	 * 백준 13706번 브론즈1
	 * 
	 * 문제 : 정수 N이 주어졌을 때, N의 제곱근을 구하는 프로그램을 작성하시오
	 * 
	 * 입력 : 양의 정수 N, N의 길이는 800자리 넘지 않는다
	 * 
	 * 출력 : N의 제곱근
	 * 
	 * */
	
	static long N;
	static double res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		res = Math.sqrt(N);
		
		System.out.println((long)res);
	}

}
