package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 *  dfs 풀이 11696KB | 88ms | 1058B | java8
 *
 */
public class Main_BOJ_14501_퇴사_S3_dfs {

    static int N;
    static int[][] tp;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        tp = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                tp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력완료

        answer = -1;
        dfs(0,0);
        System.out.println(answer);
    }
    static void dfs(int day, int pay){
        if(day==N){
            answer = Math.max(answer, pay);
            return;
        }
        if (day + tp[day][0] <= N) {
            dfs(day + tp[day][0], pay + tp[day][1]);
        }
        if(day+1<=N){
            dfs(day + 1, pay);
        }
    }
}
