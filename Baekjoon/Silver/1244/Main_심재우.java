package BOJ;

import java.util.*;

public class Main_BOJ_1244_스위치켜고끄기_S4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();	//스위치 개수
        int[] light = new int[N+1];
        for (int i = 1; i <= N; i++) {
            light[i]=sc.nextInt();
        }

        int stnum = sc.nextInt();
        ArrayList<Integer> boy = new ArrayList<>();
        ArrayList<Integer> girl = new ArrayList<>();
        int[] ss = new int[stnum];
        for (int i = 0; i < stnum; i++) {
            int x = sc.nextInt();
            ss[i]=x;
            if (x==1) {
                boy.add(sc.nextInt());
            }
            if (x==2) {
                girl.add(sc.nextInt());
            }
        }
        //===입력완료
        int index = 0;
        int index1 = 0;
        for (int i = 0; i < stnum; i++) {

            if (ss[i]==1) {
                int b = boy.get(index);
                index++;
                for (int j = 1; ; j++) {
                    if (j*b>=N+1) {
                        break;
                    }
                    if (j*b<N+1 && light[j*b]==0) {
                        light[j*b]=1;
                    }else if(j*b<N+1 && light[j*b]==1) {
                        light[j*b]=0;
                    }
                }

            }
            if (ss[i]==2) {
                int g = girl.get(index1);
                index1++;
                int gijun = light[g];
                if (gijun==0) {
                    light[g]=1;
                    for (int j = 1; ; j++) {
                        if (g-j<=0 || g+j >=N+1) {
                            break;
                        }
                        if (light[g-j]==0 && light[g+j]==0) {
                            light[g-j]=1;
                            light[g+j]=1;
                        }else if (light[g-j]==1 && light[g+j]==1) {
                            light[g-j]=0;
                            light[g+j]=0;
                        }else {
                            break;
                        }
                    }

                }
                if (gijun==1) {
                    light[g]=0;
                    for (int j = 1; ; j++) {
                        if (g-j<=0 || g+j >=N+1) {
                            break;
                        }
                        if (light[g-j]==1 && light[g+j]==1) {
                            light[g-j]=0;
                            light[g+j]=0;
                        }else if (light[g-j]==0 && light[g+j]==0) {
                            light[g-j]=1;
                            light[g+j]=1;
                        }else {
                            break;
                        }
                    }

                }

            }

        }

        //출력
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            System.out.print(light[i]+" ");
            cnt++;
            if (cnt%20==0) {
                System.out.println();
            }
        }
        System.out.print(light[N]);
    }
}
