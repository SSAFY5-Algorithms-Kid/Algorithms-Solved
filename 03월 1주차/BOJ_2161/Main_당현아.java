import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		Queue<Integer> card = new LinkedList<Integer>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++)
			card.offer(i);

		while (card.size() > 1) {
			sb.append(card.poll()).append(" "); // 하나를 꺼내서 버린다.			
			card.offer(card.poll()); // 하나를 꺼내서 맨뒤로 넣는다.
		}
		
		sb.append(card.poll());
		System.out.println(sb.toString());
	}
}