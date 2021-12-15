import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int answer = 0;
		int[][] grid = new int[100][100];
		int[][] paper = new int[N][2];
		
		for(int i=0; i<N; i++) {
			paper[i][0] = sc.nextInt();
			paper[i][1] = sc.nextInt();
		}
		
		for(int k=0; k<N; k++) {			
			for(int i=paper[k][0]; i<paper[k][0]+10; i++) {
				for(int j=paper[k][1]; j<paper[k][1]+10; j++) {
					if(grid[i][j] == 1) continue;
					else {
						grid[i][j] = 1;
						answer++;
					}
				}
			}
		}
		System.out.println(answer);

	}

}