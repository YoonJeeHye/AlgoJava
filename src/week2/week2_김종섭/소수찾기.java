package week2.week2_김종섭;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 소수찾기 {
	public static Set<Integer> setlist = new HashSet<>();
	public static List<Integer> list = new ArrayList<>();
	public static int sum = 0;
	public boolean[] isSelected = new boolean [7];
	public static int [] array;
	public static String s;
	public static StringBuilder sb = new StringBuilder();
  	
	
	
	public int solution(String numbers) {
  		
        array = new int [numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
			array[i] = numbers.charAt(i) - '0';
		}
        // 담을 array배열 생성

        for (int i = 1; i <= numbers.length(); i++) {
        	permu(0, i);
		}
        
        
        for (int n : setlist) {
			if(isSosu(n)) sum +=1;
		}
        return sum;
    }
	
	public void permu(int index, int n) {
		
		if(index == n) {
			setlist.add(Integer.parseInt(sb.toString()));
			return;
		}
		

		for (int i = 0; i < array.length; i++) {
			if(isSelected[i]) continue;
			sb.append(Integer.toString(array[i]));
			isSelected[i] = true;
			permu(index+1, n);
			isSelected[i] = false;
			sb.delete(index, index+1);
		}
	}
	
	public boolean isSosu(int number) { 
		boolean answer = true;
			switch (number) {
			case 0:
			case 1:	
				answer = false;
				break;
			case 2:
				answer = true;
				break;
			default:
				for (int j = 2; j < number; j++) {
					if((number) % j == 0) {
						answer = false;
						break;
					}
				}break;
			}return answer;
		}
	

	public static void main(String[] args) {
		소수찾기 ar = new 소수찾기();
		String numbers = "011";
		System.out.println(ar.solution(numbers));
	}

}
