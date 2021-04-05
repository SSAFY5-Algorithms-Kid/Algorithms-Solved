import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static long from, to;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());

		bfs();
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(from, 0));

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now.num == to) {
				System.out.println(now.len + 1);
				return;
			}

			if (now.num > to)
				continue;

			long temp1 = now.num * 2;
			long temp2 = (now.num) * 10 + 1;

			if (temp1 <= to)
				queue.offer(new Point(temp1, now.len + 1));
			if (temp2 <= to)
				queue.offer(new Point(temp2, now.len + 1));
		}
		System.out.println(-1);
	}

	static class Point {
		public long num;
		public int len;

		public Point(long num, int len) {
			this.num = num;
			this.len = len;
		}
	}

}