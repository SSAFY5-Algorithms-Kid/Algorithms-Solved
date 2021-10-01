import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] bingo = new int[5][5];
	static int[][] numbers = new int[5][5];
	static int answer = 0;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		loop: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				mark(numbers[i][j]);
				answer = check();
				cnt++;
				if(answer >= 3) {
					System.out.println(cnt);
					break loop;
				}
			}
		}

	}
	
	static void mark(int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(bingo[i][j] == n) bingo[i][j] = 0;
			}
		}
	}
	
	static int check() {
		int ans = 0;
		boolean flag;
		for (int i = 0; i < 5; i++) {
			flag = false;
			for (int j = 0; j < 5; j++) {
				if(flag) continue;
				if(bingo[i][j] != 0) {
					flag = true;
				}
			}
			if(!flag) ans++;
		}
		
		for (int i = 0; i < 5; i++) {
			flag = false;
			for (int j = 0; j < 5; j++) {
				if(flag) continue;
				if(bingo[j][i] != 0) {
					flag = true;
				}
			}
			if(!flag) ans++;
		}
		
		flag = false;
		for (int i = 0; i < bingo.length; i++) {
			if(flag) continue;
			if(bingo[i][i] != 0) flag = true;
		}
		if(!flag) ans++;
		
		flag = false;
		for (int i = 0; i < bingo.length; i++) {
			if(flag) continue;
			if(bingo[i][4-i] != 0) flag = true;
		}
		if(!flag) ans++;
		
		return ans;
	}

}
