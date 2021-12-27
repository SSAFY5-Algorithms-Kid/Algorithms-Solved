import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int width,height,num,sx,sy,sum;
	static int count[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width=Integer.parseInt(st.nextToken());
		height=Integer.parseInt(st.nextToken());
		num=Integer.parseInt(br.readLine());
		count=new int[num][2];
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			count[i][0]=Integer.parseInt(st.nextToken());
			count[i][1]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		sx=Integer.parseInt(st.nextToken());
		sy=Integer.parseInt(st.nextToken());
		go();
		System.out.println(sum);
	}

	private static void go() {
		// TODO Auto-generated method stub
		if(sx==1) {//북
			for(int i=0;i<num;i++) {
				if(count[i][0]==1) {
					sum+=Math.abs(count[i][1]-sy);
				}
				else if(count[i][0]==2) {
					sum+=Math.min(count[i][1]+sy,width-count[i][1]+width-sy)+height;
				}else if(count[i][0]==3) {
					sum+=count[i][1]+sy;
				}else if(count[i][0]==4) {
					sum+=width-sy+count[i][1];
				}
			}
		}
		else if(sx==2) {//남
			for(int i=0;i<num;i++) {
				if(count[i][0]==1) {
					sum+=Math.min(count[i][1]+sy,width-count[i][1]+width-sy)+height;
				}
				else if(count[i][0]==2) {
					sum+=Math.abs(count[i][1]-sy);
				}else if(count[i][0]==3) {
					sum+=height-count[i][1]+sy;
				}else if(count[i][0]==4) {
					sum+=width-sy+height-count[i][1];
				}
			}
		}else if(sx==3) {//서
			for(int i=0;i<num;i++) {
				if(count[i][0]==1) {
					sum+=count[i][1]+sy;
				}
				else if(count[i][0]==2) {
					sum+=height-sy+count[i][1];
				}else if(count[i][0]==3) {
					sum+=Math.abs(count[i][1]-sy);
				}else if(count[i][0]==4) {
					sum+=Math.min(count[i][1]+sy,height-count[i][1]+height-sy)+width;
				}
			}
		}else if(sx==4) {//동
			for(int i=0;i<num;i++) {
				if(count[i][0]==1) {
					sum+=width-count[i][1]+sy;
				}
				else if(count[i][0]==2) {
					sum+=height-sy+width-count[i][1];
				}else if(count[i][0]==3) {
					sum+=Math.min(count[i][1]+sy,height-count[i][1]+height-sy)+width;
				}else if(count[i][0]==4) {
					sum+=Math.abs(count[i][1]-sy);
				}
			}
		}
	}

}