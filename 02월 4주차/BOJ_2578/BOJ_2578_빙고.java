package Silver;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_2578_빙고 {
	/*
    * BOJ 2578 Silver5 빙고
    * 
    * 문제 : 빙고게임 3빙고 되면 몇번째 숫자만에 3빙고 됐나 출력하기
    * 
    * 입력 : 1~5째줄에 25개의 빙고 숫자가 공백을 두고 주어진다. 6~10번째 줄에 사회자가 부르는 숫자가 주어진다
    * 
    * 출력 : 사회자가 몇번째 수를 부른 후 철수가 빙고를 외치는가
    * 
    * */
	static int bingo[][]; // 빙고판
	static int num; // 사회자가 부르는 숫자
	static int bingoCnt; // 빙고 개수
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		bingo = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		} // 빙고판 입력
		
		for(int i = 0 ; i < 25; i++) { // 숫자 25개까지 있으니까 돌리기
			num = sc.nextInt(); // 사회자의 숫자 입력
			
			for(int a = 0; a < 5; a++) {
				for(int b = 0; b < 5; b++) {
					if(bingo[a][b] == num) { // 빙고판의 숫자와 같은 번호를 찾아서 0으로 만들기
						bingo[a][b] = 0;
					}
					checkVerti(); // 세로 체크
					checkHori(); // 가로체크
					checkCrossUp(); //오른쪽 대각선 위 체크
					checkCrossDown(); // 오른쪽 대각선 아래 체크
					
					if(bingoCnt == 3) { // 3빙고가 되면
						System.out.println(i); // 몇번째 숫자에서 됐나 출력
						break;
					}
					bingoCnt = 0;
				}
			}
		}
	}
	// 가로 체크
	private static void checkHori() {
		for(int i = 0 ; i < 5; i++) {
			int cntzero = 0; // 0의 개수 세는 거
			for(int j = 0; j < 5; j++) {
				if(bingo[i][j] == 0) cntzero++;
			}
			if(cntzero == 5) {
				bingoCnt++;
			}
		}
	}
	//세로 체크
	private static void checkVerti() {
		for(int j = 0 ; j < 5; j++) {
			int cntzero = 0;
			for(int i = 0; i < 5; i++) {
				if(bingo[i][j] == 0) cntzero++;
			}
			if(cntzero == 5) {
				bingoCnt++;
			}
		}
	}
	// 오른쪽 아래 대각선 체크
	private static void checkCrossDown() {
		int cntzero = 0;
		for(int i = 0; i < 5; i++) {
			if(bingo[i][i] == 0) cntzero++;
		}
		
		if(cntzero == 5) {
			bingoCnt++;
		}
	}
	
	// 오른쪽 위 대각선 체크
	private static void checkCrossUp() {
		int cntzero = 0;
		for(int i = 0; i < 5; i++) {
			if(bingo[i][4-i] == 0) cntzero++;
		}
		if(cntzero == 5) {
			bingoCnt++;
		}
	}
}
