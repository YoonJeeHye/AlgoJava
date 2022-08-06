package week1_이상원;

import java.util.Objects;
import java.util.Stack;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12909
*/
public class 올바른괄호 {
    public static void main(String[] args) {
        String s = "(())()";
        Stack<String> stack = new Stack<>(); // stack 사용

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) { // stack이 비어 있으면
                stack.push(String.valueOf(s.charAt(i))); // 추가
            } else {
                if (Objects.equals(stack.peek(), "(") && s.charAt(i) == ')') { // stack root가 (이고 현재 string이 )인 경우
                    stack.pop(); // stack 에서 pop
                } else {
                    stack.push(String.valueOf(s.charAt(i))); // 아닌 경우 추가
                }
            }
        }
//        return stack.isEmpty();
    }
}
