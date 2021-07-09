import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("BOJ.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<String> stack = new Stack<String>();

		String start = br.readLine();

		while (start.equals("고무오리 디버깅 시작")) {
			String str = br.readLine();
			
			if(str.equals("문제"))
				stack.push("문제");
			else if(str.equals("고무오리")) {
				if(stack.isEmpty()) {
					stack.push("문제");
					stack.push("문제");
				}else {
					stack.pop();
				}
			}else if(str.equals("고무오리 디버깅 끝")) break;
		}
		
		System.out.println(stack.isEmpty() ? "고무오리야 사랑해" : "힝구");
	}

}