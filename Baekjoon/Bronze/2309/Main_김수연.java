import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_김수연 {
	/*
	 * 백준 2309번 브론즈2 일곱난쟁이
	 * 
	 * 문제 : 일곱난쟁이인데 9명이 와서 자신이 주인공이라 주장했다. 일곱난쟁이의 키의 합은 100이다. 일곱난쟁이 찾기
	 * 
	 * 입력 : 9명의 난쟁이 키가 주어진다. 키는 100을 넘지 않는 자연수고 키는 모두 다르며 답이 여러가지인 경우 아무거나 출력.
	 * 
	 * 출력 : 7난쟁이의 키를 오름차순 출력한다.
	 * 
	 * */
		static int not1;
		static int not2;
		static int sum;
	
		public static void main(String[] args) {
			ArrayList<Integer>list  = new ArrayList<Integer>();
			
			Scanner sc = new Scanner(System.in);
			
			for(int i = 0; i < 9; i++) {
				int temp = sc.nextInt();
				list.add(temp);
			}

			Collections.sort(list);
			
			for(int k = 0; k < list.size(); k++) {
				sum += list.get(k);
			}
			
			for(int i = 0; i < list.size(); i++) {
				for(int j = i+1; j <list.size(); j++) {
					not1 = list.get(i);
					not2 = list.get(j);
					
					if(sum - not1 - not2 == 100) {
						break;
					}
				}
			}
			
			
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i) == not1 || list.get(i) == not2) {
					continue;
				} else {
					System.out.println(list.get(i) + " ");
				}
			}
			
		}

}
