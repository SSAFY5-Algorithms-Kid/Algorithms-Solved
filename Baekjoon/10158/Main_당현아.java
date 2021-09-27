import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int W, H, T;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("inputfile/Ant.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		T = Integer.parseInt(br.readLine());

		x = (x + T) % (W * 2);
		y = (y + T) % (H * 2);

		System.out.println((W - Math.abs(W - x)) + " " + (H - Math.abs(H - y)));
	}
}