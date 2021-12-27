package Bronze;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2605_줄세우기 {
	/*
	 * 백준 2605번 브론즈2 줄세우기
	 * 
     * 문제 : 첫번째 학생 0. 두번째 학생은 0 또는 1 중 1이면 첫번째보다 앞. 그 다음 2 뽑으면 첫째보다 두칸 앞
	 * 
	 * 입력 : 학생 수가 주어지고 줄 선 학생들이 뽑은 번호가 주어진다, 학생수 100이하.
	 * 
	 * 출력 : 학생들의 줄 선 순서대로 1부터 번호매길 때, 최종적으로 줄 선 순서 출력
	 * 
	 * */
	static int num; // 학생 수
	static ArrayList <Integer> list; // 뽑은 번호 배열
	static ArrayList <Integer> line; // 최종 줄
	
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		
 		list = new ArrayList<Integer>();
 		line = new ArrayList<Integer>();
 		
 		num = sc.nextInt(); // 학생수 입력
 		
 		for(int i = 0; i < num; i++) {
 			list.add(sc.nextInt());
 		} // 뽑은 번호 배열 입력
 		
 		for(int i = 0; i < num; i++) {
 			line.add(list.get(i), i+1);
 		}
 		
 		for(int i = num-1; i >= 0; i--) {
 			System.out.print(line.get(i) + " ");
 		}
	}

}
