package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author JAEWOO SHIM
 * @date  
 *
 * end 기준으로 정렬
 * 
 */

public class Main_BOJ_1931_회의실배정_S2 {

	static class Meeting{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Meeting[] meet = new Meeting[N];
		
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			meet[i] = new Meeting(s,e);
			
		}
		
		Arrays.sort(meet, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				if (o1.end==o2.end) {
					return o1.start-o2.start;
				}
				return o1.end-o2.end;
			}
		});
		
		int end = meet[0].end;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (meet[i].start>=end) {
				end=meet[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

