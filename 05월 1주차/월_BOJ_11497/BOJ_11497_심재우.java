package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<문제>
 *	N개의 통나무를 원형으로 놓고 뛰논다
 *	이때 각 인접한 높이의 차가 최소가 되게 한다
 *	각 높이의 차가 최소일 때 그 높이 중에서 최대를 출력한다
 *	<제약사항>
 *	첫줄에 TC가 있다
 *	통나무의 개수 N 5~10000
 *	통나무의 높이 L이 N개 있다 1~L~100000
 *	<풀이>
 *	통나무를 입력받아서 NP를 돌리면 시간초과가 날거같아서
 *	예시의 정답 배열처럼
 *	처음 입력받은 배열을 정렬해서
 *	새 배열에 양 끝으로 각각 보내주는 방식으로 배열을 새로 잡았다
 *	
 */
public class Main_BOJ_S1_11497_통나무건너뛰기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			//=====입력완료
			
			Arrays.sort(arr);	//일단 정렬
			
			int[] arr2 = new int[N];	// 값을 새로 넣을 배열 선언
			
			//arr 	0 1	  2	3	4	5
			//arr2 	0 n-1 1	n-2	2	n-3
			
			for (int i = 0, j=0; i < N/2; i++, j+=2) {	// 배열2의 양끝에 각각 넣어준다
				arr2[i]=arr[j];
				arr2[N-1-i]=arr[j+1];
			}
			if (N%2==1) {	// 배열의 크기가 홀수면 제일 가운데에 제일 큰 값을 넣어준다
				arr2[N/2]=arr[N-1];
			}
			
			int ans = Math.abs(arr2[0]-arr2[N-1]);	// ans의 초기값을 0번과 N-1번의 차로 설정
			for (int i = 1; i < N; i++) {	// 0~N-1까지 각 길이의 차를 구한다
				int abs = Math.abs(arr2[i-1]-arr2[i]);
				ans = Math.max(ans, abs);	// 큰값으로 ans 설정
			}
			
			// 출력
			System.out.println(ans);
			
		}
	}

}

/*
3
7
13 10 12 11 10 11 12
5
2 4 5 7 9
8
6 6 6 6 6 6 6 6

1
4
0
*/