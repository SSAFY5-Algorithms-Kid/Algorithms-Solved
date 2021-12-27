import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// try1 - 입력한 값과 같은 n^2의 n 찾기 < 시간초과
// try2 - 현재 입력한 중간값의 제곱으로 비교하면서 더 크면 max를 중간값으로, 더 작으면 min을 중간값으로 (이분탐색) < 성공

public class Main {

	static BigInteger target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = new BigInteger(br.readLine());

		search(new BigInteger("0"), target);
	}

	private static void search(BigInteger min, BigInteger max) {
		while (min.compareTo(max) < 0) { // min max가 역전되면 안됨
			BigInteger mid = min.add(max).divide(new BigInteger("2")); // 중간값 탐색
			BigInteger temp = mid.multiply(mid); // 중간 값의 제곱

			if (temp.compareTo(target) == 0) { // 중간 값의 제곱와 목표값이 같으면
				System.out.println(mid); // 출력하고
				return; // 함수 종료
			}

			if (temp.compareTo(target) > 0) // 목표 값보다 크면 
				max = mid; // max의 범위는 낮춤
			else // 목표값보다 작다면
				min = mid; // min의 범위를 높힘
		}
	}
}