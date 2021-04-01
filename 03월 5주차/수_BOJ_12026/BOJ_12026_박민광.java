package algo;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] res = new int[N];
		int[] map = new int[N];
		
		char[] input = sc.next().toCharArray();
		for(int i=0; i < N; i++) { 
			if(input[i]=='B') {
				map[i] = 0;
			}else if(input[i]=='O') {
				map[i] = 1;
			}else if(input[i]=='J') {
				map[i] = 2;
			}
		}
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;
		
		for(int i=1; i<N; i++) {
			int cnt = map[i];
			for(int j=0; j < i; j++) {
				if(map[j]!=(cnt+2)%3 || res[j] == Integer.MAX_VALUE) continue;
				
				res[i] = Math.min(res[j]+ (int)Math.pow(i-j, 2), res[i]);
			}
		}
		if(res[N-1]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res[N-1]);
		}
	}
}

//첫번째 실패했던 풀이, 최소가 되는 값을 구하는 경우에 반례에 막힌다. 항상 가까이에 있는 다음 목적지로 점프.

//char[] boj = {'B','O','J'};
//int N = sc.nextInt();
//char[] input = sc.next().toCharArray();
//int[] res = new int[N+1];
//int temp = 0;
//int result = 1;
//
//for(int i=0; i < N; i++) {  //모든 경우에 대해서 고려하지않고, 그리디하게 문제를 풀었던 점이 문제입니다.
//	if(input[i]== boj[temp]) {
//		res[i] = result;
//		result++;
//		temp++;
//		if(temp==3)temp=0;
//	}
//	
//}
//
//int sum = 0;
//int cnt = 0;
//int block = 0;
//System.out.println(Arrays.toString(res));
//if(res[N-1]!=0) {
//	//System.out.println(-1);
//}else {
//
//for(int i = 0; i < N; i++) {
//	if(res[i]!=0) {
//		sum += (i-block)*(i-block);
//		block = i;
//	}
//}
//System.out.println(sum);
//}
