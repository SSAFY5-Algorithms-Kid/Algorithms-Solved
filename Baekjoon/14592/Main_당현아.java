import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static PriorityQueue<Person> person;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("BOJ.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		person = new PriorityQueue<Person>();
		N = Integer.parseInt(br.readLine());

		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int tCnt = Integer.parseInt(st.nextToken());
			int tTime = Integer.parseInt(st.nextToken());

			person.offer(new Person(n, s, tCnt, tTime));
		}
		
		System.out.println(person.poll().num);
	}

	static class Person implements Comparable<Person> {
		public int num;
		public int score;
		public int tryCnt;
		public int time;

		public Person(int num, int score, int tryCnt, int time) {
			this.num = num;
			this.score = score;
			this.tryCnt = tryCnt;
			this.time = time;
		}

		@Override
		public int compareTo(Person o) {
			if (this.score == o.score) {
				if (this.tryCnt == o.tryCnt) {
					return this.time - o.time;
				}
				return this.tryCnt - o.tryCnt;
			}
			return o.score - this.score;
		}
	}
}