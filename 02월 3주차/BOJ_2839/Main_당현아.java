package selfstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SugarDeilvery_2839 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Sugar = Integer.parseInt(br.readLine());

		int fiveKG = 0, threeKG = 0;

		while (true) {
			if (Sugar % 5 == 0) {
				fiveKG += Sugar / 5;
				Sugar -= (Sugar / 5) * 5;
				break;
			} else if (Sugar <= 0)
				break;

			Sugar -= 3;
			threeKG++;
		}

		if (Sugar < 0)
			System.out.println(-1);
		else
			System.out.println(fiveKG + threeKG);
	}
}
