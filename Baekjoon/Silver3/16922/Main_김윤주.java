import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 로마숫자만들기_bj_16922 {
	
	static int N;
	static int[] src = {1, 5, 10, 50};
	static ArrayList<Integer> tgt = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		sub(0, 0, 0);
		
		// tgt 정렬해놓고 이전 값과 같으면 중복이므로 continue, 다르면 cnt++
		Collections.sort(tgt);
		int cnt = 1;	// index 0은 비교할 이전 값이 없으므로
		for(int i=1; i<tgt.size(); i++) {
			if(tgt.get(i).equals(tgt.get(i-1)))	continue;
			cnt++;
		}
		
		System.out.println(cnt);
		sc.close();
	}

	static void sub(int tgtIdx, int srcIdx, int sum) {
		if(tgtIdx == N) {
			tgt.add(sum);
			return;
		}
		
		if(srcIdx == 4)	return;
		
		sub(tgtIdx+1, srcIdx+1, sum+src[srcIdx]);
		sub(tgtIdx, srcIdx+1, sum);
		sub(tgtIdx+1, srcIdx, sum+src[srcIdx]);	// 이미 사용된 숫자 재사용
		
	}
	
}
