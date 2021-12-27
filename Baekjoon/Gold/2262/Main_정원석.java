package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2262_토너먼트만들기 {
	
	static int N, ans = 0;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int seq = N;
		for (int i = 0; i < N - 1; i++) {
			int ind = list.indexOf(seq);
			
			if (ind == 0) ans += Math.abs(list.get(ind) - list.get(ind + 1));
			else if (ind == list.size() - 1) ans += Math.abs(list.get(ind) - list.get(ind - 1));
			else ans += Math.min(Math.abs(list.get(ind) - list.get(ind - 1)), Math.abs(list.get(ind) - list.get(ind + 1)));
			
			list.remove(ind);
			
			seq--;			
		}
		
		System.out.println(ans);

	}

}
