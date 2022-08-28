package week1.week1_김종섭.src.august_1th;

import java.util.*;

public class 같은숫자는싫어 {
	
	public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] == arr[i+1]) {
                continue;
            }else list.add(arr[i+1]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

	public static void main(String[] args) {

	}

}
