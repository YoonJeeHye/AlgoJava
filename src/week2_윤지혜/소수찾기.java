package week2_윤지혜;

// 1. 가능한 숫자 경우의 수 찾아내기
// 2. 그 숫자가 소수인지 판별
public class 소수찾기 {
	static int answer;
	
	private static boolean getPrime(String s) {
		int cnt = 0;
		try {
			int n = Integer.parseInt(s);	// 중복 생김!! ㅠ
			for(int i = 2; i < n; i++) {
				if(n % i == 0) cnt++;
			}
		} catch(NumberFormatException e) {
			
		}
		if(cnt!=0) return false;
		return true;
		
	}
	
	private static void dfs(String numbers, int index, String s) {
		
		if(index == numbers.length()) {
	
			if(s!="" && s.charAt(0)!='0' && getPrime(s)) {
				answer++;
				System.out.println(s);
			}
			return;
		}
		
		dfs(numbers, index+1, s+numbers.charAt(index));
		dfs(numbers, index+1, s);
		
	}

	public static int solution(String numbers) {
		
		answer = 0;
		
		dfs(numbers, 0, "");	// ㅠㅠ dfs 어떻게 짜야되는건지 모르겠다

		
        return answer;
    }


	public static void main(String[] args) {
		
		String numbers = "17";
		System.out.println(solution(numbers));

	}

}
