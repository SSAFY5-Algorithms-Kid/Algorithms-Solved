package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_5430_AC {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output;
	static int T, N;
	static char[] P; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		T= Integer.parseInt(input.readLine());
		all:for (int t = 0; t < T; t++) {
			output = new StringBuilder();
			P = input.readLine().toCharArray();
			N= Integer.parseInt(input.readLine());
//			System.out.println(Arrays.toString(P));
//			System.out.println(N);
						
			if(N==0) {
				for (int p = 0; p < P.length; p++) {
					if(P[p] == 'D') {
						System.out.println("error");
						continue all;
					}
				}
			}
			
			String in = input.readLine();
//			System.out.println(in);
			
			String out = in.substring(1, in.length()-1);
//			System.out.println("잘라내기: " +out);
			
			
			
			String[] yes = out.split(",");
//			System.out.println(Arrays.toString(yes));
			
			//첫번째 [ 뗴기

			//마지막번째 ] 떼기 
			List<String> list = new ArrayList<>();
			
			//List<String> list = Arrays.asList(yes);
			
			for (int i = 0; i < yes.length; i++) {
				list.add(yes[i]); 
			}
			
//			System.out.println("이거임= "+list);
			
			for (int p = 0; p < P.length; p++) {
				if(P[p] == 'R') {
					//거꾸로
					Collections.reverse(list);
//					System.out.println("거꾸로: "+list);
				}
					
				else { //'D'일떄
					//지워
					if(list.size() > 0) {
//						System.out.println("너냐?");
						list.remove(0);
//						System.out.println("너냐?");						
					}
					else {
						System.out.println("error");
//						System.out.println("----------------------");
//						System.out.println();
						continue all;
					}
				}
			} 
//			System.out.println(list);
			output.append("[");
			
			for (int i = 0; i < list.size()-1; i++) {
				output.append(list.get(i) + ",");
			}
			
			output.append(list.get(list.size()-1) + "]");
			
			System.out.println(output);
			
			
//			System.out.println("----------------------");
//			System.out.println();
			
		
//			
//			for (int i = 0; i < yes.length; i++) {
//				list.add(Integer.parseInt(yes[i])); 
//			}
//			System.out.println(list);
			
			
			
			/*
			String in = input.readLine();
			char[] a = in.toCharArray();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < a.length; i++) {
				int tmp = a[i] - '0';
				if(tmp >=0 && tmp<=100) list.add(tmp);
			}//숫자만 list에 넣기
			list.remove(0);
			list.remove(list.size()-1);
			//[ 랑 ] 도 숫자로 들어와버려서 앞과 뒤 삭제
			System.out.println(list);
			System.out.println();
			
			
			//시작
			for (int p = 0; p < P.length; p++) {
				if(P[p] == 'R') {
					//거꾸로
					Collections.reverse(list);
				}
					
				else { //'D'일떄
					//지워
					if(list.size() > 0)
						list.remove(0);
					else {
						System.out.println("error");
						System.out.println("----------------------");
						System.out.println();
						continue all;
					}
				}
			} 
			System.out.println("답 = " +list);
			System.out.println("----------------------");
			System.out.println();
		*/
			
//			System.out.println("----------------------");
		}
	}
	static String src = "4\r\n" + 
			"RDD\r\n" + 
			"4\r\n" + 
			"[1,2,3,4]\r\n" + 
			"DD\r\n" + 
			"1\r\n" + 
			"[42]\r\n" + 
			"RRD\r\n" + 
			"6\r\n" + 
			"[1,1,2,3,5,8]\r\n" + 
			"D\r\n" + 
			"0\r\n" + 
			"[]";
}
