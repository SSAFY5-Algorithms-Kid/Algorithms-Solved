package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author JAEWOO SHIM
 * @date 21.04.01
 *  <제약사항>
 *  1번은 항상 B
 *  k칸 이동하면 + k*k 해주어야함
 *  
 *  <풀이>
 *  처음에 bfs로 풀었으나 시간초과가 떠서
 *  dp로 구현하니 pass가 뜸
 *
 *	답을 넣을 배열 dist[]에 앞에 나온 문자와 뒤에 나와야하는 문자일때
 *	인덱스의 차이를 이용해서 k 를 구하고
 *	기존의 값과 비교해서 최소인 값을 dist[]에 넣어준다
 *
 */
public class Main_BOJ_S1_12026_BOJ거리_dp {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());	//블록의 개수

		char[] map = new char[N];
		map = br.readLine().toCharArray();
		
		int MAX = 9999999;
		int[] dist = new int[N];
		// dist 배열을 충분히 큰 값으로 바꿔준다.
		Arrays.fill(dist, MAX);
		dist[0] = 0;	// 처음은 B로 고정 값은 0

		for (int i = 0; i < N; i++) {
			if (dist[i]==MAX) {		// BJJB같이 갈 수 없는 곳을 거른다
				continue;
			}
			for (int j = i+1; j < N; j++) {
				if (map[i] == 'B' && map[j]=='O') {
					// k = (j-1)*(j-1) 이다.
					dist[j]=Math.min(dist[j], (j-i)*(j-i)+dist[i]);
				}
				if (map[i] == 'O' && map[j]=='J') {
					dist[j]=Math.min(dist[j], (j-i)*(j-i)+dist[i]);
				}
				if (map[i] == 'J' && map[j]=='B') {
					dist[j]=Math.min(dist[j], (j-i)*(j-i)+dist[i]);
				}
			}
		}
		if (dist[N-1]!=MAX) {	// 마지막 블록이 MAX가 아니면 답 출력
			System.out.println(dist[N-1]);		
		}else {
			System.out.println("-1");
		}

	}

}
