class Solution {
    boolean solution(String s) {
        int total=0;
        for(char c : s.toCharArray()){
            if(c=='(') total++;
            else total--;
            if(total<0) return false;
        }
        if(total==0) return true;
        else return false;
    }
}