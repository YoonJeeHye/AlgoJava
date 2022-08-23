package week1.week1_이예은;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Map<Character, Character> map = new HashMap<>(); 
        // hashmap에 괄호들의 짝을 저장한다
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		map.put('>', '<');
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            char b = s.charAt(i);// 괄호를 하나씩 읽는다
            if(b == '{' || b == '(' || b == '['|| b == '<' ) {
                // 왼쪽 괄호가 나오면 stack에 push
                stack.push(b);
            } else {
                // 오른쪽 괄호가 나오면 stack에서 pop!!
				if(stack.size() == 0) {answer = false; break;}
                // pop을 할 괄호가 없다면 -> 괄호조합이 맞지 않는다
					
				char temp = stack.pop();
				if(temp != map.get(b)) {answer = false; break;}
                // pop했는데 짝이 맞지 않으면 -> 괄호조합이 맞지 않는다
            }
        }
        if(stack.size() != 0) answer = false;
        return answer;
    }
}