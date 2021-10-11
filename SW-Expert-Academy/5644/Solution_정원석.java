import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, M, bcCnt;
    static int[] Amv, Bmv;
    static int[][] bc;
    static int answer;
    static person A, B;
    static int[][] move = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            answer = 0;

            M = Integer.parseInt(st.nextToken());
            bcCnt = Integer.parseInt(st.nextToken());

            Amv = new int[M];
            Bmv = new int[M];
            bc = new int[bcCnt][4];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                Amv[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                Bmv[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < bcCnt; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    bc[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            A = new person(1, 1, new int[bcCnt]);
            B = new person(10, 10, new int[bcCnt]);
            check();
            for (int i = 0; i < M; i++) {
                A.x += move[Amv[i]][0];
                A.y += move[Amv[i]][1];
                B.x += move[Bmv[i]][0];
                B.y += move[Bmv[i]][1];
                check();

            }

            System.out.println("#" + t + " " + answer);
        }

    }

    static void check() {
        for (int i = 0; i < bcCnt; i++) {
            int dist = (Math.abs(A.x - bc[i][1]) + Math.abs(A.y - bc[i][0]));
            if (dist <= bc[i][2]) {
                A.chk[i] = bc[i][3];
            }
            dist = (Math.abs(B.x - bc[i][1]) + Math.abs(B.y - bc[i][0]));
            if (dist <= bc[i][2]) {
                B.chk[i] = bc[i][3];
            }
        }
        int max = 0;
        for (int i = 0; i < bcCnt; i++) {
            for (int j = 0; j < bcCnt; j++) {
                int tmp = 0;
                if ((i == j) && A.chk[i] != 0 && B.chk[j] != 0)
                    tmp = (A.chk[i] + B.chk[j]) / 2;
                else
                    tmp = (A.chk[i] + B.chk[j]);
                max = Math.max(max, tmp);
            }
        }
        answer += max;

        for (int i = 0; i < bcCnt; i++) {
            A.chk[i] = 0;
            B.chk[i] = 0;
        }
    }

    static class person {
        int x;
        int y;
        int[] chk;

        public person(int x, int y, int[] chk) {
            super();
            this.x = x;
            this.y = y;
            this.chk = chk;
        }
    }
}