import java.util.Scanner;

public class Main{
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean[] visit = new boolean[1000000];
		
		for(int one = 0; one <= n; one++) {
			for(int five = 0; five <= n - one; five++) {
				for(int ten = 0; ten <= n - one - five; ten++) {
					int fifty  = n - one - five - ten;
					int sum = one + five * 5 + ten * 10 + fifty * 50;
					visit[sum] = true;
				}
			}
		}
		int res = 0;
		for(int i = 1; i < visit.length; i++) {
			if(visit[i]==true)res++;
		}
		System.out.println(res);	
   }
}