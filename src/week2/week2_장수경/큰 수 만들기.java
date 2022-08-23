package week2.week2_장수경;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String number, int k) {
    	ArrayList<Integer> list = new ArrayList<>();
        String ans="";
        int index = 0;
        int next = 0;
        
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            
            for (int j = index; j <= i + k; j++) {
                int current = number.charAt(j) - '0';

                if (max < current) {
                    max = current;
                    next = j;
                }
            }
            list.add(max);
            index = next + 1;
        }
        for(int i:list) {
        	ans+=i;
        }
        return ans;
    }
}
