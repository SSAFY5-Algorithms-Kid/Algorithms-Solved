import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇프로젝트_bj_3649 {
	
	static int x, N;
	static int[] rego;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String temp = br.readLine();
//			if(temp == null) break;			//백준 제출할때는 이렇게
			if(temp.equals("")) break;		//이클립스에서 테스트 할때는 이렇게
			
			x = Integer.parseInt(temp) * 10000000;		// 나노미터로 단위 통합해줌
			N = Integer.parseInt(br.readLine());
			
			rego = new int[N];
			
			for(int i=0; i<N; i++) {
				rego[i] = Integer.parseInt(br.readLine());
			}
			
			// 이진탐색
			binary();
		}
		
		// 출력
		System.out.print(sb);
	}
	
	
	static void binary() {
		// 오름차순 정렬
		Arrays.sort(rego);
		
		// 양 끝에서 탐색 시작
		int left = 0;
		int right = N-1;
		
		while(left < right) {
			
			int sum = rego[left] + rego[right];
			
			if(sum > x) right--;			// 합이 x보다 크면 오른쪽 인덱스-1
			else if(sum < x) left++;		// 합이 x보다 작으면 왼쪽 인덱스+1
			else {							// 두 레고의 합이 x와 같으면 출력문구 sb에 더해주고 return
				sb.append("yes " + rego[left] + " " + rego[right] + "\n");
				return;
			}
			
		}
		
		// while문이 끝까지 돌고 온 경우 구멍을 막을 수 있는 조각이 없을때이므로 danger sb에 더해줌
		sb.append("danger" + "\n");
		
	}

}
