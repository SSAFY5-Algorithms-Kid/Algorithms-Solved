import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int size;
	static int[][] mat;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		mat = new int[size][size];
		
		for(int i=0;i<size;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<size;j++) {
				mat[i][j]=Integer.parseInt(temp[j]);			
			}
		}
		
		// bfs를 이용하여 섬마다 mark
		Queue<node> mark = new LinkedList<>();
		int M=2;
		boolean[][] c = new boolean[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(mat[i][j]==0||c[i][j]) continue;
				mat[i][j]=M;
				mark.add(new node(i,j));
				c[i][j]=true;
				
				while(!mark.isEmpty()) {
					node temp = mark.poll();
					for(int k=0;k<4;k++) {
						int curx = temp.x+dx[k];
						int cury = temp.y+dy[k];
						
						if(checkBoundary(curx,cury) && mat[curx][cury]==1&&!c[curx][cury]) {
							mat[curx][cury]=M;
							c[curx][cury]=true;
							mark.add(new node(curx,cury));
						}
						
					}
				}
				M++;
			}
		}
		
		// bfs를 이용하여 섬간 거리 count
		Queue<node> q = new LinkedList<>();
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(mat[i][j]==0||!checkValid(i,j)) continue;
				
				boolean[][] chk = new boolean[size][size];
				int mk = mat[i][j];
				
				q.add(new node(i,j));
				chk[i][j]=true;
				int cnt=0;
				
				loop: while(!q.isEmpty()) {
					
					int count = q.size();
					for(int n=0;n<count;n++) {
						node tmp = q.poll();
						for(int k=0;k<4;k++) {
							int curx = tmp.x+dx[k];
							int cury = tmp.y+dy[k];
							
							if(checkBoundary(curx,cury) && mat[curx][cury]!=mk && mat[curx][cury]!=0) {
								q.clear();
								break loop;
							}
							if(checkBoundary(curx,cury) && mat[curx][cury]==0 && !chk[curx][cury]) {
								q.add(new node(curx,cury));
								chk[curx][cury]=true;
							}						
						}
					}
					cnt++;
				}
				min = Math.min(min,cnt);
			}
		}
		System.out.println(min);

	}
	
	// 섬간 거리 계산시 갈수 있는 방향의 유효성 확인 method
	static boolean checkValid(int x,int y) {
		for(int i=0;i<4;i++) {
			int tmpx = x+dx[i];
			int tmpy = y+dy[i];
			if(checkBoundary(tmpx,tmpy) && mat[tmpx][tmpy]==0) return true;
		}
		return false;
	}
	
	// matrix 범위 check method
	static boolean checkBoundary(int x, int y) {
		if(x<0||x>=size||y<0||y>=size) return false;
		return true;
	}
	
}

// 좌표 object class
class node{
	int x;
	int y;
	public node(int x, int y) {
		this.x=x;
		this.y=y;
	}
}