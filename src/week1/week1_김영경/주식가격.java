package week1.week1_김영경;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

	public int[] solution(int[] prices) {
		int a = 0;
		int[] ans = new int[prices.length];
		Arrays.fill(ans, 0);

		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				ans[i]++;
				if (prices[i] > prices[j])
					break;
			}
		}

		return ans;

	}

}
