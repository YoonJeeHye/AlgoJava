class Solution {
    int letter(char c){//글자로 바꾸기
        return c - 'A';    
    }
    
    public int solution(String name) {
    	int n = name.length();
        int answer = 0;
        char[] arr = new char[n];
        for(int i = 0; i < arr.length; i++) arr[i] = 'A';
        int cur = 0;
        
        while(true){
            int minDis = n;
            int minIdx = -1;//최소 인덱스
            for(int i = 0; i < n; i++){
                if(arr[i] == name.charAt(i)) continue;
                
                int dis = Math.min(Math.abs(cur - i), n - Math.abs(cur - i));
                if(dis < minDis){
                    minDis = dis;
                    minIdx = i;
                }
            }
            
            if(minIdx == -1)
                break;
            
            answer += minDis;
            int move1 = letter(name.charAt(minIdx)) - letter('A');
            int move2 = letter('Z') - letter(name.charAt(minIdx)) + 1;
            answer += Math.min(move1, move2);
            arr[minIdx] = name.charAt(minIdx);
            cur = minIdx;
        }
        
        return answer;
    }
}
