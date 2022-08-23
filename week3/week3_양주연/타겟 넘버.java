class Solution {
    int N, cnt=0;
    void dfs(int lev, int[] numbers, int total, int target){
        if(lev==N){ //기저조건
            if(total==target) cnt++; //계산결과가 타겟 넘버일 경우 cnt++
        }
        else{
            dfs(lev+1, numbers, total-numbers[lev], target); //해당 숫자 더함
            dfs(lev+1, numbers, total+numbers[lev], target); //해당 숫자 뺌
        }
    }
    public int solution(int[] numbers, int target) {
        N = numbers.length; //주어지는 숫자 개수
        dfs(0, numbers, 0, target); //dfs() 호출
        return cnt;
    }
}