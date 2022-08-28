package week2.week2_윤지혜;

import java.util.ArrayList;

public class 카펫 {
	
	public static int[] solution(int brown, int yellow) {
		
		int sum = brown + yellow;
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= sum; i++) {	// mul의 약수 구하기
			if(sum % i == 0) {
				list.add(i);
			}
		}
	
		int[] answer = new int[2];
		
		
		  for(int i = 0; i < list.size(); i++){
			  for(int j = 0; j < list.size(); j++) {
				  
				  if((list.get(i)-2) * (list.get(j)-2) == yellow) {
					  answer[0] = list.get(i);
					  answer[1] = list.get(j);
				  }
				  
			  }
		  }
		 
		
		System.out.println(answer[0]+" "+answer[1]);
        
        return answer;
    }

	public static void main(String[] args) {

		solution(24, 24);

	}

}
