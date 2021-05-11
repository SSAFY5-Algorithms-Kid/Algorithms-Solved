package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.time.format.ResolverStyle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
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
		output = new StringBuilder();
		for (int t = 0; t < T; t++) {
			P = input.readLine().toCharArray();
			N= Integer.parseInt(input.readLine());
			int evenR = 1;
			//System.out.println(Arrays.toString(P));
			//System.out.println(N);
			
			String in = input.readLine();
			//System.out.println(in);
			
			
			
			String out = in.substring(1, in.length()-1);
			//System.out.println("잘라내기: " +out);
			
			String[] yes = out.split(",");
			//System.out.println(Arrays.toString(yes));
			
			if(N==0 && noNum_D()) {
				continue;
			}
			
			if(N==0 && noNum_R()) {
				continue;
			}
			
			Deque<Integer> dq = new ArrayDeque<>();
			
			for (int i = 0; i < yes.length; i++) {
				dq.add(Integer.parseInt(yes[i]));
			}
			
			//System.out.println("deque= "+dq);
			
			
			for (int p = 0; p < P.length; p++) {
				if(P[p] == 'R') {
					//거꾸로
					evenR *= -1;
				}

				else { //'D'일떄
					//지워
					if(dq.size()!=0) { //dq가 있을때
						//1. R이 짝수개일때 evenR = 1
						if(evenR == 1) {
							//앞에서부터 빼기
							dq.pollFirst();
						}
						//2. R이 홀수개일때 evenR = -1
						else {
							//뒤에서부터 빼기
							dq.pollLast();
						}
					}
					else {//dq가 비어있을때 D가오면
						//System.out.println("답인가?"+ "error");
						output.append("error\n");
						break;
					}
				}
			}
			if(evenR == -1) { // 다 했는데 R이 홀수개일때
				//뒤집어
				Deque<Integer> tmp = new ArrayDeque<>();
				while(!dq.isEmpty()) {
					tmp.addFirst(dq.pollFirst());
				}
				//System.out.println("tmp= "+tmp );
				dq = tmp;
			}
			if(!dq.isEmpty()) {
				//System.out.println("답인가?" + dq);
				output.append("[");
				int size = dq.size();
				for (int i = 0; i < size-1; i++) {
					output.append(dq.pollFirst()+",");
				}
				output.append(dq.pollFirst()+"]\n");				
			}
			//System.out.println();
		}
		System.out.print(output);
	}
	private static boolean noNum_R() {
		for (int p = 0; p < P.length; p++) {
			if(P[p] == 'R') {
				output.append("[]\n");
				return true;
			}
		}
		return false;
	}
	private static boolean noNum_D() {
		for (int p = 0; p < P.length; p++) {
			if(P[p] == 'D') {
				//System.out.println("답인가?"+"error");
				output.append("error\n");
				return true;
			}
		}
		return false;
	}
	static String src = "2\r\n" + 
			"D\r\n" + 
			"0\r\n" + 
			"[]\r\n" + 
			"R\r\n" + 
			"0\r\n" + 
			"[]";
}
