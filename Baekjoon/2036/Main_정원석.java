package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No2036_수열의점수 {
	
	static int N, zeroCnt = 0;
	static long ans = 0;
	static PriorityQueue<Integer> pos, neg;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		pos = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}			
		});
		
		neg = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			if(cur > 0) pos.offer(cur);
			else if(cur < 0) neg.offer(cur);
			else zeroCnt++;
		}
		
		while(pos.size() > 1) {
			int cur1 = pos.poll();
			int cur2 = pos.poll();
			if(cur1 != 1 && cur2 != 1) ans += ((long)(cur1) * (long)(cur2));
			else {
				ans += cur1;
				ans += cur2;
			}
		}
		
		if(!pos.isEmpty()) ans += pos.poll();
		
		while(neg.size() > 1) {
			ans += ((long)(neg.poll()) * (long)(neg.poll()));
		}
		
		if(!neg.isEmpty() && zeroCnt == 0) ans += neg.poll();
		
		System.out.println(ans);	

	}

}
