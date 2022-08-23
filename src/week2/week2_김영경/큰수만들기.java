package week2.week2_김영경;

import java.util.*;

class 큰수만들기 {
    
    static int target;
    static String ans="0";
    static String inp;
    static int leng;
    
    static void dfs(String number,int level,int idx){
        if(level==target) {
            if(number.compareTo(ans)>0)
                ans=number;
        }
        else
        {
            for(int i=idx;i<leng;i++){
                    dfs(number+Character.toString(inp.charAt(i)),level+1,i+1);
                }
        }
    }
    
    public static String solution(String number, int k) {
        inp=number;
        leng=number.length();
        target=leng-k;
        dfs("",0,0);
        
        return ans;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("1924", 2);
	}
}