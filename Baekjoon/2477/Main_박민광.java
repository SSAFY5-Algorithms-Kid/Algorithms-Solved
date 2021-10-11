import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int input[][] = new int [6][2];
        for( int i=0; i < 6; i++) {
        	input[i][0] = sc.nextInt();
        	input[i][1] = sc.nextInt(); 
        }
        int ga = 0;
        int gacha = 0;
        int se = 0;
        int secha = 0;
        for(int j=0; j < 6; j++) {
        	if((input[j][0]==1||input[j][0]==2) && input[j][1] > ga) {
        		ga = input[j][1];
        		if(j==0) {
        			gacha = Math.abs(input[5][1] - input[j+1][1]);
        			continue;
        		}else if(j==5) {
        			gacha = Math.abs(input[j-1][1] - input[0][1]);
        			continue;
        		}
        		gacha = Math.abs(input[j-1][1] - input[j+1][1]);
        		
        	}else if((input[j][0]==3||input[j][0]==4) && input[j][1] > se) {
        		se = input[j][1];
        		if(j==0) {
        			secha = Math.abs(input[5][1] - input[j+1][1]);
        			continue;
        		}else if(j==5) {
        			secha = Math.abs(input[j-1][1] - input[0][1]);
        			continue;
        		}
        		secha = Math.abs(input[j-1][1] - input[j+1][1]);
        		
        	}
        	
        }
        System.out.println((ga*se - (gacha*secha))*T);
        
	}
}  
