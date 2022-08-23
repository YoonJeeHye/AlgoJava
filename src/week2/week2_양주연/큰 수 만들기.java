package week2.week2_양주연;

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int resLen = number.length()-k;
        for(int i=0; i<number.length(); i++){
            int tmp = number.charAt(i)-48;
            while(!stack.isEmpty() && stack.peek()<tmp && k-->0){
                stack.pop();
            }
            stack.push(tmp);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<resLen; i++){
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}