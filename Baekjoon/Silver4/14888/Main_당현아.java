import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, MAX, MIN;
	static int[] numbers;
	static char[] operator, nowOp;
	static boolean[] opCheck;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		numbers = new int[N];
		operator = new char[N - 1];
		nowOp = new char[N-1];
		opCheck = new boolean[N - 1];
		
		MIN = Integer.MAX_VALUE;
		MAX = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());

		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < cnt; j++) {
				if (i == 0) operator[idx++] = '+';
				else if (i == 1) operator[idx++] = '-';
				else if (i == 2) operator[idx++] = '*';
				else if (i == 3) operator[idx++] = '/';
			}
		}

		//System.out.println(Arrays.toString(operator));
		permutation(0);
		System.out.println(MAX);
		System.out.println(MIN);
	}

	private static void permutation(int idx){
		if(idx == N-1) {
			//System.out.println(Arrays.toString(nowOp));
			String[] expression = makeExpression(nowOp);
			int result = eval(expression);
			
			MIN = Math.min(MIN, result);
			MAX = Math.max(MAX, result);
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if(opCheck[i])
				continue;
			
			nowOp[idx] = operator[i];
			opCheck[i] = true;
			permutation(idx + 1);
			opCheck[i] = false;
		}
	}

	private static int eval(String[] expression) {
		int result = Integer.parseInt(expression[0]);
		//System.out.println(Arrays.toString(expression));

		for (int i = 1; i < expression.length; i++) {
			switch (expression[i++]) {
			case "+":
				result += Integer.parseInt(expression[i]);
				break;
			case "-":
				result -= Integer.parseInt(expression[i]);
				break;
			case "*":
				result *= Integer.parseInt(expression[i]);
				break;
			case "/":
				result /= Integer.parseInt(expression[i]);
				break;
			}
		}
		
		return result;
	}

	private static String[] makeExpression(char[] op){
		String[] Expression = new String[N+(N-1)];
		int idx=0;

		for (int i = 0; i < N - 1; i++) {
			Expression[idx++] = Integer.toString(numbers[i]);
			Expression[idx++] = Character.toString(op[i]);
		}
		Expression[idx] = Integer.toString(numbers[N-1]);

		return Expression;
	}
}