package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * 210719 mon 주사위
 * 
 * 저어어엉말 많이 틀리고 해결한 문제
 * 해답을 구하기 위해서 정말 최적화하여 도달하기까지 반례들이 많아서 까다로웠다.
 * N이 1인 경우, 마지막까지 괴롭힘을 당했다.
 * */

public class No1041_주사위 {
	
	static long N, one, two = Integer.MAX_VALUE, three = Integer.MAX_VALUE;
	static long ans;
	static num[] dice;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		
		
		
		dice = new num[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			dice[i] = new num(Integer.parseInt(st.nextToken()), i);
		}
		
		Arrays.sort(dice);
		
		if(N == 1) {
			long ans = 0;
			for (int i = 0; i < 6; i++) {
				ans += dice[i].n;
			}
			ans -= dice[5].n;
			System.out.println(ans);
			System.exit(0);
		}
		
		one = dice[0].n;
		
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				if(chkValid(dice[i], dice[j])) two = Math.min(two, dice[i].n + dice[j].n);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 5; j++) {
				for (int k = j + 1; k < 6; k++) {
					if(chkValid(dice[i], dice[j]) && chkValid(dice[i], dice[k]) && chkValid(dice[k], dice[j])) 
						three = Math.min(three, dice[i].n + dice[j].n + dice[k].n);
				}
			}
		}
		
		ans = (4 * three) + ((8 * N - 12) * two)  + ((N - 2) * (5 * N - 6) * one);
		
		System.out.println(ans);	
		
	}
	
	static boolean chkValid(num n1, num n2) {
		if(n1.ind + n2.ind == 5) return false;
		return true;
	}
	
	static class num implements Comparable<num>{
		int n, ind;

		public num(int n, int ind) {
			super();
			this.n = n;
			this.ind = ind;
		}

		@Override
		public int compareTo(num o) {
			return this.n - o.n;
		}
		
	}

}
