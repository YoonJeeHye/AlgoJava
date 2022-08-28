package week2.week2_장수경;

import java.util.*;

class Solution {

    boolean[] visit; 
    char[] arr; 
    Set<Integer> set = new HashSet<>();//중복 제거

    public boolean isPrime(int n) {//소수 확인
        if(n == 1 || n == 0) return false;

        for(int i = 2; i < n; i++) {
            if(n%i == 0) return false;
        }

        return true;
    }

    //배열 char형을 int로
    public int charsToInt(char[] arr, int length) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }

        return Integer.parseInt(sb.toString());
    }

    public void dfs(int level, int length, String numbers) {//순열 찾기
        if(level == length) {
            int num = charsToInt(arr, length);
            if(isPrime(num)) set.add(num);
        } else {
            for(int i = 0; i < numbers.length(); i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    arr[level] = numbers.charAt(i);
                    dfs(level+1, length, numbers);
                    visit[i] = false;
                }
            }
        }
    }

    public int solution(String numbers) {
        visit = new boolean[numbers.length()];
        arr = new char[numbers.length()];

        for(int i = 1; i <= numbers.length(); i++) {
           dfs(0, i, numbers);
        }

        return set.size();
    }
}
