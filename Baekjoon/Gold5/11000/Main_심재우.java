package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 시작시간 순으로 정렬해서 그리디로 강의실 개수를 새준다.
 *
 * 처음엔 종료시간 순으로 정렬했지만 틀렸던 문제.
 *
 */
public class Main_BOJ_11000_강의실배정_G5 {

	static class Meeting{
		int start;
		int end;
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);

		int N = scann.nextInt();

		Meeting[] meeting = new Meeting[N];

		for (int i = 0; i < N; i++) {
			int s = scann.nextInt();
			int e = scann.nextInt();

			meeting[i] = new Meeting(s,e);
		}

		Arrays.sort(meeting, new Comparator<Meeting>(){

			@Override
			public int compare(Meeting o1, Meeting o2) {
				if (o1.start==o2.start) {
					return o1.end - o2.end;
				}
				return o1.start-o2.start;
			}

		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(meeting[0].end);

		for (int i = 1; i < N; i++) {
			if (pq.peek() <= meeting[i].start) {
				pq.poll();
			}
			pq.offer(meeting[i].end);
		}
		System.out.println(pq.size());
	}

}
