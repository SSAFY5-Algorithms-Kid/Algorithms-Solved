import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_김윤주 {

	static int N;
	static int[] path;	// 블록 나열된 형태
	static int[] memoi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		path = new int[N];
		String input = br.readLine();
		
		// memoi를 위해 boj를 012로 블록을 인덱스화? 해줌
		for(int i=0; i<N; i++) {
			switch(input.charAt(i)) {
			case 'B':
				path[i] = 0;
				break;
			case 'O':
				path[i] = 1;
				break;
			case 'J':
				path[i] = 2;
			}
		}
		
		// memoi를 MAX_VALUE로 초기화해줌
		// 이동하지 못하는 블록은 MAX_VALUE로 남아있을 것
		// 단, 첫번째 블록은 출발점이므로 0으로 초기화
		memoi = new int[N];
		Arrays.fill(memoi, Integer.MAX_VALUE);
		memoi[0] = 0;
		
		// memoi
		for(int i=1; i<N; i++) {
			int idx = path[i];
			for(int j=0; j<i; j++) {
				// path[j]가 path[i]의 이전 블록이 될 수 없거나, 한번도 지나오지 않은 블록이면 continue
				if(path[j] != (idx+2)%3 || memoi[j] == Integer.MAX_VALUE) continue;
				
				// path[j]가 path[i]의 이전 블록이 될 수 있는 경우
				// path[i]까지 새로운 루트(path[j]까지의 최소거리 + path[i]로 점프하는데 필요한 에너지 양)과 현재 path[i]까지의 거리를 비교하여 최솟값 저장
				memoi[i] = Math.min(memoi[j] + (int) Math.pow(i-j, 2), memoi[i]);
			}
		}
		
		// 위의 memoi랑 똑같은 로직!
		// path를 인덱스화 함으로써 코드가 더 깔끔해짐. 시간은 거의 차이 없음.
//		for(int i=1; i<N; i++) {
//			switch(path[i]) {
//			case 'B':
//				for(int j=0; j<i; j++) {
//					if(path[j]=='J' && memoi[j] != Integer.MAX_VALUE)
//						memoi[i] = Math.min(memoi[j]+(i-j)*(i-j), memoi[i]);
//				}
//				break;
//				
//			case 'O':
//				for(int j=0; j<i; j++) {
//					if(path[j]=='B' && memoi[j] != Integer.MAX_VALUE)
//						memoi[i] = Math.min(memoi[j]+(i-j)*(i-j), memoi[i]);
//				}
//				break;
//				
//			case 'J':
//				for(int j=0; j<i; j++) {
//					if(path[j]=='O' && memoi[j] != Integer.MAX_VALUE)
//						memoi[i] = Math.min(memoi[j]+(i-j)*(i-j), memoi[i]);
//				}
//				break;
//			}
//		}
		
		// memoi[N-1]이 MAX_VALUE인 경우는 마지막 블록에 도달하지 못한 경우 이므로 -1 출력
		if(memoi[N-1] == Integer.MAX_VALUE)	System.out.println(-1);
		else	System.out.println(memoi[N-1]);
	}

}
