package beakjoon;

import java.util.Scanner;

public class NEachSum_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		char[] temp = sc.next().toCharArray();

		for (int i = 0; i < N; i++) 
			sum += temp[i] - '0';		

		System.out.println(sum);
		sc.close();
	}
}
