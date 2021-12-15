import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] dwarf = new int[9];
	static int[] tgt = new int[7];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}
		
		comb(0, 0);
		
	}
	
	static void comb(int srcind, int tgtind) {
		if(tgtind == 7) {
			int chk = 0;
			for (int i = 0; i < 7; i++) {
				chk += tgt[i];
			}
			if(chk == 100) {
				Arrays.sort(tgt);
				for (int i = 0; i < 7; i++) {
					System.out.println(tgt[i]);
				}
			}
			
			return;
		}
		
		if(srcind == 9) return;
		
		comb(srcind+1, tgtind);
		tgt[tgtind] = dwarf[srcind];
		comb(srcind+1, tgtind+1);
	}

}
