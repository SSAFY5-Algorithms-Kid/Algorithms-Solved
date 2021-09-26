import java.util.Scanner;

public class Main {
	static int N, TOTAL;
	static int[] switchArray;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		switchArray = new int[N];

		for (int i = 0; i < N; i++)
			switchArray[i] = sc.nextInt();

		TOTAL = sc.nextInt();
		for (int tryCnt = 0; tryCnt < TOTAL; tryCnt++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();

			if (gender == 1) // 남자일 경우 - 배수
				for (int i = (number - 1); i < N; i += number)
					switchArray[i] = (switchArray[i] == 0) ? 1 : 0;
			else { // 여자일 경우 - 대칭확인
				switchArray[number - 1] = (switchArray[number - 1] == 0) ? 1 : 0;
				for (int i = 1; (number-1) - i >= 0 && i + (number-1) < N; i++) {
		            if (switchArray[(number-1) - i] == switchArray[(number-1) + i]) {
		                switchArray[(number-1) - i] = (switchArray[(number-1) - i] == 0) ? 1 : 0;
		                switchArray[(number-1) + i] = (switchArray[(number-1) + i] == 0) ? 1 : 0;
		            }
		            else break;
		        }
			}

		}

		for (int i = 0; i < switchArray.length; i++) {
			System.out.print(switchArray[i] + " ");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
		sc.close();
	}

}