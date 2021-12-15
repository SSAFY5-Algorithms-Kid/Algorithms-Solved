package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chesspiece_3003 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("");
		int[] piece = {1,1,2,2,2,8};
		
		for(int i=0;i<piece.length;i++) {
			piece[i] -= Integer.parseInt(st.nextToken());
			sb.append(piece[i]);
			
			if(i<piece.length-1)
				sb.append(" ");
		}
	
		System.out.println(sb);
	}
}
