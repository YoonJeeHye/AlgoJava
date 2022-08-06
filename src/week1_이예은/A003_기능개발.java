import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] days = new int[progresses.length];
        List<Integer> counts = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            days[i] = (int) Math.ceil((100 - progresses[i]) * 1.0 / speeds[i]);
            // 기능을 완료하기 위해 며칠이 필요한지 올림을 사용해서 구한다
        }
        
        int prev = days[0];
        int cnt = 0;
        for(int i = 0; i < days.length; i++){
            if(days[i] <= prev){ // 이전 기능이 완료하기 필요했던 day보다 작거나 같으면
                cnt++;// count를 1 추가한다
            }
            else{// 이전 기능이 완료하기 필요했던 day보다 크다면
                prev = days[i];
                counts.add(cnt);
                cnt = 1;// count를 1로 초기화한다
            }
        }
        counts.add(cnt);// 마지막으로 남아 있는 cnt를 결과 리스트에 넣어준다
        
        answer = counts.stream().mapToInt(i->i).toArray(); //Arraylist -> Array
        return answer;
    }
}