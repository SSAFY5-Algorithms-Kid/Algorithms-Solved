package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindFraction_1193 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int i = 1, j = 1, dir = 1;

		for (int x = 1; x < X; x++) {
			i -= dir;
			j += dir;
			
			if (i < 1) {
				dir = -1;
				i = 1;
			} else if (j < 1) {
				dir = 1;
				j = 1;
			}
		}
		System.out.println(i + "/" + j);
	}
}
