package BOJ;

import java.util.Scanner;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 주어진 인덱스부터 10*10만큼 1로 바꿔주고
 * 전체 배열중에서 1인것 카운트
 *
 */
public class Main_BOJ_2563_색종이_S5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] paper=new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                paper[i][j]=0;
            }
        }

        for (int n = 0; n < N; n++) {

            int c = sc.nextInt();
            int r = sc.nextInt();

            for (int i = 90-r ; i < 100-r; i++) {

                for (int j = 90-c; j < 100-c; j++) {

                    paper[i][j]=1;

                }
            }

        }
        int ans=0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]==1) {
                    ans++;
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
