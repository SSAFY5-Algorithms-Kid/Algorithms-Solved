package BOJ;

import java.io.*;
import java.util.*;

/**
 * @Date :
 * @Author : JAEWOO SHIM
 *
 * 시작과 마지막은 반드시 1
 * x에서 출발해서 y에 도착하는 최솟값을 구해라
 *
 * 입력 :
 * 첫줄에는 TC
 * 현재위치(x) 목표위치(y)
 * x는 항상 y보다 작은 값을 갖는다 (0 <= x < y < 2^31 ) 2^31 = 2,147,483,648 y는 int선에서 해결가능
 *
 * 제일 마지막은 반드시 1광년을 이동하므로 y-x-1 만큼의 거리를 이동하는데 드는 횟수를 구하고 마지막에 +1
 *
 */
public class Main_BOJ_1011_FmttAC_G5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int i = 1; i <= TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = y - x;

            int max = (int)Math.sqrt(dist);
            if(max == Math.sqrt(dist)) {
                System.out.println(max * 2 - 1);
            }
            else if(dist <= max * max + max) {
                System.out.println(max * 2);
            }
            else {
                System.out.println(max * 2 + 1);
            }
        }
    }
}

/*
3
0 3
1 5
45 50

2
0 1
0 2

1
0 2147483647

*/