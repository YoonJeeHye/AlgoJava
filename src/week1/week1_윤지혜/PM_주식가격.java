package week1.week1_윤지혜;

import java.util.*;

public class PM_주식가격 {
	
	public static int[] solution(int[] prices) {
		
		int cnt = 0;
		int[] answer = new int[prices.length];
	    
	    for (int i = 0; i < prices.length-1; i++)
	    {
	        for (int j = i+1; j < prices.length; j++)
	        {
	            if (prices[i] <= prices[j])
	            {
	                cnt++;
	            }
	            else
	            {
	                cnt++;
	                break;
	            }
	        }
	        answer[i] = cnt;
	        cnt = 0;
	    }
	    
	    answer[prices.length-1] = 0;
	    
	    return answer;
    }

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,2,3};
		solution(arr);

	}

}
