package week1_이상원;

import java.util.Stack;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12906
*/
public class 같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            }
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        Object[] answer = stack.toArray();
//        return answer;
    }
}
