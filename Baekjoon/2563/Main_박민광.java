import java.util.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {	
		int N = scan.nextInt();
		int[][] map = new int[100][100];
		int count = 0;
		for(int i = 0; i < N; i++) {
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			for(int j = b; j < b + 10; j++) {
				for(int k = a; k < a + 10; k++) {
					if(map[j][k]==1) {
						continue;
					}
					map[j][k] = 1;
					count += 1;		
				}
			}
					
		}
		System.out.println(count);
	}
}