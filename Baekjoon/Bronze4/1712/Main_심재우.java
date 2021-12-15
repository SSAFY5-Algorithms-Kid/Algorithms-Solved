import java.io.*;
import java.util.*;

public class Main_BOJ_1712_손익분기점_B4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int BC = B-C;
        if (BC >= 0) {
            System.out.println("-1");
        }else{
            System.out.println((A/(-BC))+1);    //BC가 0이면 ArithmeticException 발생
        }
    }
}
