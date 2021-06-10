import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fibo(N));
	}

	public static int fibo(int num) {
		if (num < 2)
			return num;
		return fibo(num - 1) + fibo(num - 2);
	}
}