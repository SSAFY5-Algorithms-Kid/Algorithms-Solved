package BOJ;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * Combination을 이용.
 *
 */
public class Main_BOJ_14889_스타트와링크_S3 {
    static int T;
    static int N;
    static int[][] table;
    static int ans;
    static int[] food;
    static int[] tlrwofy;

    static ArrayList<Integer> syn = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        table = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                table[i][j] = sc.nextInt();

            }
        }
        food = new int[N / 2];
        tlrwofy = new int[N];

        for (int i = 0; i < N; i++) {
            tlrwofy[i] = i;
        }
        nCr(0, 0);
        ans = Integer.MAX_VALUE;
        plus();
        syn.clear();
        System.out.println(ans);

    }

    private static void nCr(int cnt, int start) {

        if (cnt == N / 2) {
            int k = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = (N / 2) - 1; j >= 0; j--) {
                    k += table[food[i]][food[j]];
                }
            }
            syn.add(k);
            return;
        }
        for (int i = start; i < N; i++) {
            food[cnt] = tlrwofy[i];
            nCr(cnt + 1, i + 1);
        }
    }

    static void plus() {
        int syner = 0;
        for (int i = 0; i < syn.size() / 2; i++) {
            syner = Math.abs(syn.get(i) - syn.get(syn.size() - i - 1));
            ans = Math.min(syner, ans);
        }
    }
}
