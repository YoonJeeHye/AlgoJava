package week1.week1_윤지혜;

import java.util.Stack;

public class PM_올바른괄호 {
	
	public static boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == ')') {
        		if(stack.empty()) {
        			answer = false;
        			break;
        		}else if(stack.peek() == '(') {
        			stack.pop();
        		}
        	}else {
        		stack.push(s.charAt(i));
        	}
        }
        
        if(!stack.empty()) {
        	answer = false;
        }
        System.out.println(answer);
        return answer;
    }

	public static void main(String[] args) {
		
		String a = ")()(";
		solution(a);

	}

}
