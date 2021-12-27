import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N+1];
		for(int i = 1; i<=N; i++) {
			input[i] = sc.nextInt();
		}
		int S = sc.nextInt();
		for(int s = 0; s<S; s++) {
			int se = sc.nextInt();
			int no = sc.nextInt();
			
			if(se==1) {
				for(int j=no; j<=N; j+=no) {
					input[j]=input[j]==0?1:0;
				}
			}
			else if(se==2) {
				int cnt = 0;
				for(int k=1; k<=N; k++) {
					if(no-k>0&& no+k<=N&&input[no-k]==input[no+k]) {
						cnt++;
					}else {
						break;
					}
				}
				for(int l=no-cnt; l<=no+cnt; l++) {
					input[l]=input[l]==0?1:0;
					}
				}
			}
		for(int a=1; a<=N; a++) {
			
			System.out.print(input[a]+" ");	
			if(a%20==0)System.out.println();
		}
	}
}

