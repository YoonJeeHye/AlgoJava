import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> queue = new ArrayList<>();
        int prev = 10;
        //int size = 0;
        
        for(int num: arr){
            if (num == prev) continue; // 이전 숫자와 같아면 넘어간다
            queue.add(num); // 이전 숫자와 같지 않으면 큐에 넣는다
            prev = num; // 이전 숫자값을 다시 갱신한다
            //size++;
        }
        int[] answer = queue.stream().mapToInt(i->i).toArray();
        return answer;
    }
}