package May_1;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BOJ_No17214_다항함수의적분 {
	
	static String p;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		p = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		String[] tmp = p.split("x");
		
		// 16
		if(p.charAt(p.length()-1) != 'x' && tmp.length == 1) {
			if(p.equals("0")) sb.append("W");
			else if(p.equals("1")) sb.append("x+W");
			else if(p.equals("-1")) sb.append("-x+W");
			else {
				sb.append(p);
				sb.append("x+W");
			}
		}else {
			int t = Integer.parseInt(tmp[0]) / 2;
			if(t != 1 && t != -1) sb.append(Integer.toString(t));
			else if(t == -1) sb.append("-");
			sb.append("xx");
			if(tmp.length > 1) {
				sb.append(tmp[1].charAt(0));
				if(!tmp[1].substring(1, tmp[1].length()).equals("1")) sb.append(tmp[1].substring(1, tmp[1].length()));
				
				sb.append("x+W");
			}else sb.append("+W");			
			
		}
		System.out.println(sb.toString());
		
		
		
	}

}
