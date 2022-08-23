package week1.week1_양주연;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int prev=-1, cnt=0;
        for(int x : arr){
            if(x!=prev){
                prev=x;
                cnt++;
            }
        }
        int[] answer = new int[cnt];
        prev=-1;
        int idx=0;
        for(int x : arr){
            if(x!=prev){
                prev=x;
                answer[idx++]=x;
            }
        }
        return answer;
    }
}