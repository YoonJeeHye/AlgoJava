package week2.week2_김종섭;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 큰수만들기 {
	// 시간초과 1개 + 런타임 에러 1개
 	public String solution(String number, int k) {
 		
        int max = 0, t = 0, k0 = k;
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		// 1. arrayList에 넣기
		
		
		
		//2. 최댓값을 확인하고, 최대가 아니면 삭제한다.
		max = 0;
		for (int i = 0; i < number.length(); i++) {
			list.add(number.charAt(i)-'0');
		}
		
		while(k > 0 && t<k0) {
			max = 0;
			for (int i = t; i <= t + k; i++) {
				if((list.get(i)) > max) max = list.get(i);
			}
			while (list.get(t) != max) {
				list.remove(t);
				 k--;
			}t++;
		}

			for (int i1 = 0; i1 < list.size(); i1++) {
				sb.append(list.get(i1));    
			}	
				
		return sb.toString();
		
    }
 	
 	public static void main(String[] args) {
 		큰수만들기 ar = new 큰수만들기();
 		String number = "4177252841";
 		int k = 4;
 		System.out.println(ar.solution(number, k));
	}

}
