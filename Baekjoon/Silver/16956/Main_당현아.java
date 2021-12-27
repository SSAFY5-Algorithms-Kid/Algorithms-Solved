import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static Queue<Walf> list = new LinkedList<Walf>();

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("BOJ.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'W')
					list.add(new Walf(i, j));
			}
		}
		
		StringBuffer sb = new StringBuffer();
		boolean result = close();
		
		sb.append(result?1:0);
		
		if(result) {
			sb.append("\n");
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}

	private static void printArr(char[][] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));
	}
	
	static int[][] DELTA = {{0,1},{0,-1},{1,0},{-1,0}};
	private static boolean close() {
		if(list.isEmpty())
			return true;
		else {
			int n = list.size();
			for(int i=0;i<n;i++) {
				Walf w = list.poll();
				int x = w.x;
				int y = w.y;
				
				for(int d=0;d<4;d++) {
					int nx = x+DELTA[d][0];
					int ny = y+DELTA[d][1];
					
					if(nx < 0 || nx>=R||ny<0||ny>=C)
						continue;
					
					if(map[nx][ny] == 'D'||map[nx][ny] == 'W')
						continue;
					else if(map[nx][ny] == 'S')
						return false;
					
					map[nx][ny] = 'D';					
				}
			}
			
			return true;
		}
	}

	static class Walf {
		public int x;
		public int y;

		public Walf(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}