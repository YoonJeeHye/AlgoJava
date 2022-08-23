package week2.week2_양주연;

class Solution {
    public int solution(String name) {
        int len = name.length();
        int up_down_cnt=0, right_left_cnt=len-1;
        for(int i=0; i<len; i++){
            char c = name.charAt(i);
            up_down_cnt+=Math.min(c-'A', 'Z'-c+1);
            
            int idx = i+1;
            while(idx<len && name.charAt(idx)=='A'){
                idx++;
            }
            right_left_cnt = Math.min(right_left_cnt, i+len-idx+Math.min(i, len-idx));
        }
        return up_down_cnt+right_left_cnt;
    }
}