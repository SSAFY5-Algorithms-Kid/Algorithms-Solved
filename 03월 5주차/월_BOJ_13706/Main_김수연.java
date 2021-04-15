
import java.util.Scanner;

class Solution {
	static int[][] arr;
	static int N, power, tc;

	public static void main(String args[]) throws ArrayIndexOutOfBoundsException {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			power = sc.nextInt();
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int a = sc.nextInt();
					arr[i][j] = a;
				}
			}

			int resup = upside(power, arr);
			int rescs = cross(power, arr);

			if (resup > rescs) {
				System.out.println("#" + tc + " " + resup);
			} else {
				System.out.println("#" + tc + " " + rescs);
			}
		}
		sc.close();

	}
	
	
	private static int upside(int power, int arr[][]) throws ArrayIndexOutOfBoundsException {
		int sum = 0;
		int upmax = 0;
		
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					sum += arr[i][j];
					for (int k = 1; k <= power; k++) {
						sum += arr[i + k][j];
						sum += arr[i - k][j];
						sum += arr[i][j - k];
						sum += arr[i][j + k];
						
					}
					if (sum > upmax) {
						upmax = sum;
					}
				}
			}
			return upmax;
		} 
		


	private static int cross(int power, int arr[][])throws ArrayIndexOutOfBoundsException {
		int sum = 0;
		int csmax = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += arr[i][j];
				for (int k = 1; k <= power; k++) {
					sum += arr[i + k][j + k];
					sum += arr[i - k][j - k];
					sum += arr[i + k][j - k];
					sum += arr[i - k][j + k];
					
				}
				if (sum > csmax) {
					csmax = sum;
				}
			}
		}

		return csmax;
	}
	// 배열 벗어나면 처리하는 거 어떻게 하는지 모르겠다

}

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

