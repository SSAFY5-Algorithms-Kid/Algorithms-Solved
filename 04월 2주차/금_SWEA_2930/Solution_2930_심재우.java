package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * @author JAEWOO SHIM
 * @date  
 *	최대 힙을 구현하라.
 *	
 *	연산이 1이 들어오면 트리에 넣고
 *	연산이 2가 들어오면 루트 노드를 제거하여 그 값을 출력하라
 *	
 *	힙은 priorityqueue를 이용하면 알아서 계산을 해주기 때문에 pq를 이용하였고
 *	최대 힙을 구현하는 것이 목표이므로 pq에서 큰값을 우선으로 선언해주었다
 *	루트노드에서 가지고온 ( 제거한 ) 값은 list에 저장해서 
 *	마지막으로 list에 있는 값들을 출력해준다
 */
public class Solution_D3_2930_힙 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
		
			int N = Integer.parseInt(br.readLine());
			
			// 높은 숫자 순의 pq
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			ArrayList<Integer> list = new ArrayList<>();
			
			// 연산 1 = 삽입
			// 연산 2 = 최댓값 출력 후 해당 키값 삭제
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				if (st.countTokens()==2) {
					int oper = Integer.parseInt(st.nextToken());
					int addnum = Integer.parseInt(st.nextToken());
					
					pq.add(addnum);
					
				}else {
					int delnum = Integer.parseInt(st.nextToken());
					
					if (!pq.isEmpty()) {
						int max = pq.poll();
						list.add(max);
					}else {
						list.add(-1);
					}
				}
			}
			System.out.print("#"+t+" ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			
		}
	}

}
