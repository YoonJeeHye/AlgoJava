package week1.week1_김종섭.src.august_1th;

import java.util.*;

public class 스택_주식가격 {
	
	public int[] solution(int[] prices) {
		Deque<Integer> stock = new LinkedList<>();
		for (int i = 0; i < prices.length-1; i++) {
			int count = 0;
			for (int j = i; j < prices.length-1; j++) {
                count ++;
				if(prices[i] <= prices[j+1]) {
					continue;
				}else {
					break;
				}
			}stock.offerLast(count);
		}stock.offerLast(0);
		
        return stock.stream().mapToInt(Integer :: intValue).toArray();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
