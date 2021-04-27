package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * @author JAEWOO SHIM
 * @date  
 *	<문제>
 *	수빈이의 현재 위치가 x 일때 1초 뒤 수빈이는 x-1, x+1, 2x 로 움직이고
 *	동생은 k, k+1, k+1+2, ... 으로 움직인다
 *	수빈이가 동생을 찾는 가장 빠른 시간을 출력하라
 *	수빈이가 동생을 찾을 수 없거나 찾는 위치가 500000을 넘어가면 -1을 출력한다.
 *
 *	<제약사항>
 *	0 <= n, k <= 500000
 *	
 *  <풀이>
 *  그냥 일반적인 bfs로 풀게되면 시간초과가 난다.
 *  수빈이의 위치가 +-1을 하는것을 이용해서 동생의 위치일때 수빈이가 갈 수 있는지
 *  여부를 판단해주는 방식으로 시도했다.
 */
public class Main_BOJ_G1_17071_숨바꼭질5 {

	// Node 클래스를 만들어서 관리
	static class Node{
		int n;	// 수빈이 위치
		int k;	// 동생 위치
		int idx;	// v 배열의 [][j] 값을 결정
		int kcnt;	// 시간이 얼마나 지났는지
		
		public Node(int n, int k, int idx, int kcnt) {
			super();
			this.n = n;
			this.k = k;
			this.idx = idx;
			this.kcnt = kcnt;
		}
		@Override
		public String toString() {
			return "Node [n=" + n + ", k=" + k + ", idx=" + idx + ", kcnt=" + kcnt + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 수빈이의 처음 위치
		int k = sc.nextInt();	// 동생의 처음 위치
		
		int[][] v = new int[500001][2];	// 인덱스가 홀수/짝수인 경우에 반복되는 것을 이용하기 위해 2차원 배열을 사용
		int j = 0;	//시작하는 인덱스는 0
		
		Queue<Node> que = new LinkedList<Node>();
		// que에 초기위치 넣고 v 배열에 1 넣어주고 시작
		que.offer(new Node(n,k,j,1));
		v[n][j]=1;
		while(!que.isEmpty()) {
			Node curr = que.poll();
			if (curr.k>500000) {	// 제약사항
				break;
			}
			// v[동생의위치][얘가 2*n칸 전에 나왔었니]? 를 판단 or 수빈위치 == 동생위치 이면 return;
			if (v[curr.k][(curr.kcnt-1)%2]!=0 || curr.n==curr.k) {
				System.out.println(curr.kcnt-1);
				return;
			}
			
			// 수빈이의 이동위치에 따라 que에 넣어줌
			if (curr.n-1>=0 && v[curr.n-1][1-curr.idx]==0) {
				que.offer(new Node(curr.n-1, curr.k+curr.kcnt, 1-curr.idx, curr.kcnt+1));
				v[curr.n-1][1-curr.idx]=1;
			}
			if (curr.n+1<=500000 && v[curr.n+1][1-curr.idx]==0) {
				que.offer(new Node(curr.n+1, curr.k+curr.kcnt, 1-curr.idx, curr.kcnt+1));
				v[curr.n+1][1-curr.idx]=1;
			}
			if (curr.n *2<=500000 && v[curr.n *2][1-curr.idx]==0) {
				que.offer(new Node(curr.n *2, curr.k+curr.kcnt, 1-curr.idx, curr.kcnt+1));
				v[curr.n *2][1-curr.idx]=1;
			}
			
			
		}
		// 여기까지 왔으면 못 찾은것이라 -1 출력
		System.out.println("-1");
		
	}

}
