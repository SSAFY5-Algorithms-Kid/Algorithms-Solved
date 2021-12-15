package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No11000_강의실배정 {
	
	static int N, answer = 1;
	static Class[] lecture;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		lecture = new Class[N];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lecture[i] = new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lecture);
	
		pq.offer(lecture[0].end);
		
		for (int i = 1; i < N; i++) {
			int min = pq.poll();
			if(min > lecture[i].start) pq.offer(min);
			pq.offer(lecture[i].end);
		}
		
		System.out.println(pq.size());

	}
	
	static class Class implements Comparable<Class>{
		int start, end;

		public Class(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}		

		@Override
		public int compareTo(Class o) {
			int res = this.start - o.start;
			return res != 0 ? res : this.end - o.end;
		}
		
	}

}
