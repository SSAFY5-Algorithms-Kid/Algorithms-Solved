import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        
        if(M == 4 || M == 7) {
        	System.out.println(-1);
        }
        else if(M%5 == 0)System.out.println(M/5);
        else if(M%5 == 1 || M%5==3)System.out.println(M/5+1);
        else System.out.println(M/5+2);
    	
    }
}  
