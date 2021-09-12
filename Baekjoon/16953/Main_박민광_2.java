package algo;
import java.util.*;

public class Main {
	public static int A;
	public static int B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Point> q = new LinkedList<>();
		A = sc.nextInt();
		B = sc.nextInt();
		
		q.offer(new Point(A,0));

		while(!q.isEmpty()) {
			Point p = q.poll();

			if(p.x == B) {
				System.out.println(p.y+1);
				System.exit(0);
			}
			for(int i=0; i<2; i++) {
				int x = 0;
				if(i==0) {
					x = 2*p.x;
				}
				else {
					x = (10*p.x) + 1;
				}
				if(x <= B) {
					q.add(new Point(x,p.y+1));
				}
			}
		}
		System.out.println(-1);
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
