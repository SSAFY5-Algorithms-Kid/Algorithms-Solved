package May_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_No5430_AC {
	
	static int T, N;
	static String func;
	static StringBuilder nums;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		loop: for (int t = 1; t <= T; t++) {
			func = br.readLine();
			func = func.replace("RR", "");
			
			N = Integer.parseInt(br.readLine());
			
			String tmp = br.readLine();
			nums = new StringBuilder(tmp.substring(1, tmp.length()-1));
			
			boolean flag = false;
			for (int i = 0, size = func.length(); i < size; i++) {
				if(func.charAt(i) == 'R') {
					if(flag) flag = false;
					else flag = true;
				}
				else if(func.charAt(i) == 'D') {
					if(nums.length() == 0) {
						System.out.println("error");
						continue loop;
					}else {
						if(!flag) nums.delete(0, getInd(flag));
						else {
							nums.delete(getInd(flag), nums.length());
						}
					}
				}
				
				
			}
			if(flag) {
				String[] tmp2 = nums.toString().split(",");
				nums = new StringBuilder();
				for (int i = tmp2.length-1; i >= 0; i--) {
					nums.append(tmp2[i]);
					if(i != 0) nums.append(",");
				}
				
			}
			nums.insert(0, "[");
			nums.append("]");
			System.out.println(nums.toString());
		}

	}
	static int getInd(boolean flag) {
		if(!flag) {
			for (int i = 0; i < nums.length(); i++) {
				if(nums.charAt(i) == ',') {
					return i+1;				
				}
			}
			return nums.length();
		}else {
			for (int i = nums.length() - 1; i >= 0; i--) {
				if(nums.charAt(i) == ',') return i;
			}
			return 0;
		}
	}

}
