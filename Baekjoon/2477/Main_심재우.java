package BOJ;

import java.util.Scanner;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 무조건 변의 순서대로 반시계방향으로 진행하므로
 * 가장 긴 가로와 세로의 변에서 각각 3칸씩 가면
 * 잘려나가는 세로와 가로의 길이를 알 수 있다.
 *
 */
public class Main_BOJ_2477_참외밭_S5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        int[] cham = new int[6];
        int w = 0;
        int h = 0;
        int wi = 0;
        int hi = 0;
        int x = 0;
        for (int i = 0; i < 6; i++) {
            x = sc.nextInt();
            cham[i] = sc.nextInt();
            if (x == 1 || x == 2) {
                w = Math.max(w, cham[i]); //가로 최대 길이 찾기
                if (w == cham[i]) {
                    wi = i;
                }
            }
            if (x == 3 || x == 4) {
                h = Math.max(h, cham[i]); //세로 최대 길이 찾기
                if (h == cham[i]) {
                    hi = i;
                }
            }
        }
        int a = 0;
        int b = 0;
        if (wi + 3 >= 6) {
            wi = wi + 3 - 6; // 초과한 인덱스 처리
            a = cham[wi];
        } else {
            a = cham[wi + 3];
        }
        if (hi + 3 >= 6) {
            hi = hi + 3 - 6;
            b = cham[hi];
        } else {
            b = cham[hi + 3];
        }
        int ans = w * h - a * b;
        System.out.println(ans * K);
    }
}
