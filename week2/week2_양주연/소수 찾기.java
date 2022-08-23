import java.util.*;
class Solution {
    boolean[] isSelected;
    Set<Integer> set;
    String nums;
    int N;
    boolean isPrime(int num){
        if(num==0 || num==1) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
    void permutation(int lev, String num){
        if(lev==N) return;
        else{
            for(int i=0; i<N; i++){
                if(isSelected[i]) continue;
                isSelected[i] = true;
                int tmp = Integer.parseInt(num + nums.charAt(i));
                if(isPrime(tmp)) set.add(tmp);
                permutation(lev+1, num + nums.charAt(i));
                isSelected[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        nums = numbers;
        int answer = 0;
        N = numbers.length();
        isSelected = new boolean[N];
        set = new HashSet<>();
        permutation(0, "");
        return set.size();
    }
}