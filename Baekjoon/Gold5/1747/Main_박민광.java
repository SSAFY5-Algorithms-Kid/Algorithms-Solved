import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main_1747 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[2000001];
        prime[1] = true;
        // false->prime;
        int n = sc.nextInt();
        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j += i) { //소수의 배수들을 모두 방문처리!!
                    prime[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = n ; i < prime.length; i++) {
            if (!prime[i] && isPal(i)) {
                res = i;
                break;
            }
        }
        System.out.println(res);

    }
    public static boolean isPal(int n) {
        char[] num = Integer.toString(n).toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length; i++) {
            if (num.length % 2 == 1 && i == num.length / 2) { //홀수자리 수 처리 
                continue;
            }
            if (i < num.length / 2) { //절반까지 스택에 넣기 
                st.push(num[i]);
            } else {
                if (st.peek() == num[i]) { //스택의 맨위를 보고, 다음 숫자와같으면 pop 아니면 false 
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}