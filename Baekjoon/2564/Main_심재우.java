package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 * @author JAEWOO SHIM
 * @date 21.04.13
 *
 * 직사각형을 직선으로 펼쳐서 거리를 잰다.
 *
 */
public class Main_BOJ_2564_경비원_S1_2 {

	static int n, m;
	static int store;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 가로길이
		m = Integer.parseInt(st.nextToken()); // 세로길이

		store = Integer.parseInt(br.readLine());	// 상점의 개수

		int[] point = new int[store+1];
		for (int i = 0; i < store+1; i++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			// |--------|--------|--------|-----------|---->직선 좌표
			// 0    	n       n+m      2n+m       2(n+m)

			if (D==1) {	//북 0~n
				point[i]=W;
			}
			if (D==2) {	//남 n+m ~ 2n+m
				point[i]=((2*n)+m)-W;
			}
			if (D==3) {	//서 2n+m ~ 2(n+m)
				point[i]=2*(n+m)-W;
			}
			if (D==4) {	//동 n ~ n+m
				point[i]=n+W;
			}

		}

		int totaldist = 2*(n+m);
		int dong = point[store];
		int ans = 0;
		for (int i = 0; i < point.length-1; i++) {
			int d1 = Math.abs(dong-point[i]);
			int d2 = totaldist-d1;
			ans += Math.min(d1,d2);
		}
		System.out.println(ans);
	}

}