import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int K, answer;
    static int[][] gear, r;
    
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][8];
        
        for(int i = 0; i < 4; i++){        
            String tmp = br.readLine();
            for(int j = 0; j < 8; j++){
                gear[i][j] = Integer.parseInt(tmp.substring(j, j+1));
            }
        }
        
        K = Integer.parseInt(br.readLine());
        r = new int[K][2];
        
        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i][0] = Integer.parseInt(st.nextToken());
            r[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < K; i++){
            int num = r[i][0] - 1;
            int d = r[i][1];
            if(num == 0) upRoll(num, d);
            else if(num == 3) downRoll(num, d);
            else {
                upRoll(num, d);
                rotate(num, d * (-1));
                downRoll(num, d);            		
            }
        }
            
            
        for(int i = 0; i < 4; i++){
            answer += Math.pow(2, i) * gear[i][0];
        }
        System.out.println(answer);
	}
	
	static void upRoll(int num, int direct) {
		if(num == 3) {
			rotate(num, direct);
			return;
		}
		
		if(gear[num][2] != gear[num+1][6]) {
			upRoll(num+1, direct * (-1));		
		}
		rotate(num, direct);
	}
	
	static void downRoll(int num, int direct) {
		if(num == 0) {
			rotate(num, direct);
			return;
		}
		
		if(gear[num][6] != gear[num-1][2]) {
			downRoll(num-1, direct * (-1));
		}
		rotate(num, direct);
	}
    
    static void rotate(int num, int direct){
		
        if(direct == 1){
        	int tmp = gear[num][7];
            for(int i = 7; i > 0; i--){
            	gear[num][i] = gear[num][i-1];
            }
            gear[num][0] = tmp;
        }
         else if(direct == -1){
        	int tmp = gear[num][0];
            for(int i = 0; i < 7; i++){
            	gear[num][i] = gear[num][i+1];
            }
            gear[num][7] = tmp;
        }
        
    }

}
