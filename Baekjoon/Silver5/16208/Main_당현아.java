import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, Total;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			Total += n;
			arr[i] = n;
		}
		
		Arrays.sort(arr);
		
		long Result = 0;
		for(int i=0;i<N;i++) {
			Result += arr[i] * (Total-arr[i]);
			Total -= arr[i];
		}
		System.out.println(Result);
	}
}