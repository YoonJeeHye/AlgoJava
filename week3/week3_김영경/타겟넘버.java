class Solution {
    
    int target;
    int[] numbers;
    int cnt;
    
    public void dfs(int level,int sum){
        if(level==numbers.length){
            if(sum==target)
                cnt++;
        }
        else{
            dfs(level+1,sum-numbers[level]);
            dfs(level+1,sum+numbers[level]);
        }
    }
    
    public int solution(int[] Numbers, int Target) {
        numbers=Numbers;
        target=Target;
        dfs(0,0);
        return cnt;
    }
}
