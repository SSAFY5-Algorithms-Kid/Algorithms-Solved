package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * dp   11536KB | 80ms | 941B | java8
 *
 */
public class Main_BOJ_14501_퇴사_S3_dp {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] tp = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                tp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력완료

        int[] dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            if (i + tp[i][0] <= N) {
                dp[i + tp[i][0]] = Math.max(dp[i + tp[i][0]], dp[i] + tp[i][1]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]); //주의
        }
        System.out.println(dp[N]);
    }
}
/*
4
3 10
1 20
1 30
2 10

50

7
3 10
5 20
1 10
2 20
4 15
2 10
2 200

40

4
3 5
1 1
1 2
1 3

8

5
4 10
2 9
2 3
2 2
3 100

11

*/
