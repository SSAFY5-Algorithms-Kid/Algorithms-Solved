package BOJ;

import java.io.*;
import java.util.*;
/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * RRR GGG BBB
 * RGB
 * RG GB BR
 * RR GG BB
 * R G B
 *
 * 순으로 뽑았다.
 *
 */
public class Main_BOJ_10800_컬러볼_G3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Ball> balls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls.add(new Ball(i, c, s));
        }

        // 크기가 작은 순으로 Ball 리스트 정렬
        Collections.sort(balls, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o1.size - o2.size;
            }
        });

        int[] answer = new int[n];

        int sum = 0;
        int[] color = new int[n + 1];
        for (int i = 0, j = 0; i < n; i++) {
            Ball a = balls.get(i);
            Ball b = balls.get(j);

            // 이전 공의 크기가 현재 공의 크기보다 작은 경우만
            while (b.size < a.size) {
                sum += b.size;  // 작은 공의 크기 누적
                color[b.color] += b.size;  // 작은 공의 색 인덱스 위치에 작은 공의 크기를 추가

                b = balls.get(++j);  // 다음 공 뽑기
            }

            // 현재 공이 잡을 수 있는 공의 수 (크기가 작은 전체 누적 공 크기 - 현재 공과 같은 색의 공 크기 합)
            answer[a.idx] = sum - color[a.color];
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);

    }

    // Ball 클래스 (인덱스, 색, 크기)
    private static class Ball {
        int idx;
        int color;
        int size;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
}
