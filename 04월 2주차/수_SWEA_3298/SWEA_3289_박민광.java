import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_3289_서로소집합 {

	private static int N,M;
	private static int[] parents;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int c,a,b;
		
		for(int t=1; t<=T; ++t) {
			N = in.nextInt();//자연수
			M = in.nextInt();//연산의 개수
			
			parents = new int[N+1];
			
			// 부분트리(그룹) 생성 : 각 노드가 해당 집합의 대표노드가 되도록 단위집합을 만드는 작업(n개의 노드라면 n개의 집합)
			// 				  모든 노드는 처음 시작시 개별적인 트리로 보므로 모든 노드가 루트노드가 된다. 루트노드에 -1로 세팅 후 시작
					
			Arrays.fill(parents, -1); 
			
			StringBuilder builder = new StringBuilder();
			builder.append("#").append(t).append(" ");
			
			for(int i=0; i<M; ++i) { 
				c = in.nextInt(); // 명령구분  0, 1
				a = in.nextInt(); // a노드
				b = in.nextInt(); // b노드
				
				switch(c) {
					case 0: // 두노드 합치기
						union(a,b);
						break;
					case 1: // 두노드의 루트노드 비교하기
						builder.append((find(a)==find(b))? "1":"0" );
						break;
				}
			}
			
			System.out.println(builder.toString());
		}
		in.close();
	}
	
	private static int find(int a) {
		if(parents[a] == -1) return a; 
		// 자신이 루트노드라면 자기노드번호 리턴
		return parents[a] = find(parents[a]); 
		// 자신의 부모를 따라 결국 루트노드를 찾아 리턴받고 자신의 부모를 자기 트리의 루트노드로 갱신하여 트리의 depth를 줄인다.
	}

	private static void union(int a,int b) {
		int pa = find(a); // a노드가 속해 있는 트리(그룹)의 루트노드 찾기
		int pb = find(b); // b노드가 속해 있는 트리(그룹)의 루트노드 찾기
		// 두 노드의 루트노드가 다르다면 한쪽 트리에 다른 트리 합치기
		if(pa != pb) parents[pb] = pa;
	}

}