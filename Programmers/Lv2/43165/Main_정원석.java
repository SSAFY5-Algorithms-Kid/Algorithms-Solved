package May_2;

public class Programmers_타겟넘버 {
	
	static int answer = 0;

	public static void main(String[] args) {

		System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));

	}
	
	static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
		return answer;
	}
	
	static void dfs(int[] numbers, int target, int ind, int res) {
		if(ind == numbers.length) {
			if(target == res) answer++;
			return;
		}
		
		dfs(numbers, target, ind + 1, res + numbers[ind]);
		dfs(numbers, target, ind + 1, res - numbers[ind]);
	}

}
