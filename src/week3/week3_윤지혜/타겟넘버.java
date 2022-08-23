package week3.week3_윤지혜;

import java.util.*;

public class 타겟넘버 {

	static int answer;
	static int[] numbers;
	static int target;
	public static void main(String[] args) {
		
		numbers = new int[]{4, 1, 2, 1};
		target = 4;
		
		solution(numbers, target);
		System.out.println(answer);

	}

	public static int solution(int[] numbers, int target) {
        dfs(0, 0);
        return answer;
    }

	private static void dfs(int sum, int index) {
		if(index == numbers.length) {	// numbers 배열 크기만큼 다 돌면 끝
			if(sum == target) answer++;	// 다 더한 값이랑 target 값이랑 같으면 answer++
			return;
		}
		
		dfs(sum + numbers[index], index+1);
		dfs(sum - numbers[index], index+1);
	}

}
