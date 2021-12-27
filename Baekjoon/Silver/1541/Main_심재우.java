import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 음수 뒤에 (
 * +숫자 뒤에 )
 *
 */
public class Main_BOJ_1541_잃어버린괄호_S2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> calc = new ArrayList<>();
        calc.add('0');
        String[] str = br.readLine().split("");
        String tmp = "";
        for (int i = 0; i < str.length; i++) {

            if (!str[i].equals("+") && !str[i].equals("-")){
                tmp += str[i];
            }
            else{
                nums.add(Integer.parseInt(tmp));
                calc.add(str[i].charAt(0));
                tmp = "";
            }
        }
        nums.add(Integer.parseInt(tmp));

        int ans = nums.get(0);
        boolean flag = true; // true 면 +
        for (int i = 1; i < nums.size(); i++) {
            if (calc.get(i)=='+' && flag){
                ans += nums.get(i);
            } else if (calc.get(i) == '-') {
                flag = false;
                ans -= nums.get(i);
            } else if (calc.get(i) == '+' && !flag) {
                ans -= nums.get(i);
            }

        }
        System.out.println(ans);

    }
}
