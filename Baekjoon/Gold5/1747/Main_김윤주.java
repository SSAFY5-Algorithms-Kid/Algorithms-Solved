import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 소수팰린드롬_bj_1747 {

	static int N;
	static boolean flag;
	static final int max = 1003002;			// N의 최대값인 1000000 이상의 수 중 가장 작은 팰린드롬 수는 1003001이므로 eratos길이를 1003002로 지정해줌
	static boolean[] eratos = new boolean[max];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// false가 소수
		// N이 1일 경우를 대비하여 1 true로 마킹
		eratos[1] = true;
		for(int i=2; i<max; i++) {
			for(int j=i+i; j<max; j+=i) {
				eratos[j] = true;
			}
		}
		
		for(int i=N; i<max; i++) {
			// 소수인 i에 한하여
			if(!eratos[i]) {
				// i를 string으로 변환하여 길이 판단
				String tmp = i+"";
				int tmpL = tmp.length();
				
				// 길이가 1일 경우는 무조건 팰린드롬
				if(tmpL == 1) flag = true;
				
				// 대칭되는 자리를 차례로 비교하여 다르다면 바로 break
				// 가장 안쪽까지 같다면 flag를 true로 마킹
				for(int j=0; j<tmpL/2; j++) {
					if(tmp.charAt(j) != tmp.charAt(tmpL-1-j))	break;
					if(j == (tmpL/2)-1 && tmp.charAt(j) == tmp.charAt(tmpL-1-j)) flag = true;
				}
			}
			
			// i가 팰린드롬이면 (flag==true) i출력하고 반복문 종료
			if(flag) {
				System.out.println(i);
				break;
			}
		}


	}

}
