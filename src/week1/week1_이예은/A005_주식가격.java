package week1.week1_이예은;

import java.util.Stack;

class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();// 시간 인덱스가 들어간다
        
        for(int cur = 0; cur < prices.length; cur++){
            while(stack.size() != 0  && prices[stack.peek()] > prices[cur]){
                // stack에 가장 위에 들어 있는 time의 주식 prices 보다
                // cur 시간의 주식 prices가 크면 stack에서 pop한다
                int time = stack.pop();
                answer[time] = cur - time;// 현재 시간과 그당시 시간의 차이를 결과로 저장한다
            }
            stack.push(cur);
            // stack에 가장 위에 들어 있는 time의 주식 prices 보다
            // cur 시간의 주식 prices가 작거나 같으면 cur 시간을 stack에 push한다
        }
        
        while(stack.size() != 0) { 
            // stack에 남아 있는  시간들과 끝난 시간의 차이를 결과로 넣어준다
        	int time = stack.pop();
            answer[time] = prices.length - time - 1; 
            // time이 0부터 들어 갔기 때문에 1을 더해준다
        }

        return answer;
    }
}