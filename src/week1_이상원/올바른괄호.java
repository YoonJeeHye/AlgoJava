package week1_이상원;

import java.util.Objects;
import java.util.Stack;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12909
*/
public class 올바른괄호 {
    public static void main(String[] args) {
        String s = "(())()";
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                if (Objects.equals(stack.peek(), "(") && s.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(String.valueOf(s.charAt(i)));
                }
            }
        }
//        return stack.isEmpty();
    }
}
