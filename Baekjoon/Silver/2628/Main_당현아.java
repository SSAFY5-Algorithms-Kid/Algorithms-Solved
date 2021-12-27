import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer> row, col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		row = new ArrayList<Integer>();
		col = new ArrayList<Integer>();
		row.add(0);
		row.add(M);
		col.add(0);
		col.add(N);

		int L = Integer.parseInt(br.readLine());

		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());

			if (num == 0)
				row.add(point);
			else
				col.add(point);
		}

		Collections.sort(row);
		Collections.sort(col);

		int n_row = row.size(), n_col = col.size();
		int max_row = 0, max_col = 0;

		for (int i = 1; i < n_row; i++) 
			max_row = Math.max(max_row, row.get(i) - row.get(i - 1));
		for (int i = 1; i < n_col; i++) 
			max_col = Math.max(max_col, col.get(i) - col.get(i - 1));

		System.out.println(max_row * max_col);
	}
}
