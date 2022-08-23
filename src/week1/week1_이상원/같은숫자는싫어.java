package week1.week1_이상원;

import java.util.Stack;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12906
*/
public class 같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        Stack<Integer> stack = new Stack<>(); // stack 사용
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) { // stack 이 비어 있으면
                stack.push(arr[i]); // 하나 추가하기
            }
            if (stack.peek() != arr[i]) { // stack의 top에 있는 값 반환, 다음 값과 비교, 불일치 시
                stack.push(arr[i]); // stack에 추가 => 같으면 넘어가는 것
            }
        }
        Object[] answer = stack.toArray(); // stack을 Object array로 변경
//        return answer;
    }
}
