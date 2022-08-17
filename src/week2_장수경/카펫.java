class Solution {
    static public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        
        int sum = brown + red;
        
        for(int i=1; i< (sum/2) ; i++) {
        	if(sum%i == 0) {
        		int c = sum/i;
        		if((c-2)*(i-2) == red) {
        			answer[0] = Math.max(c, i);
        			answer[1] = Math.min(c, i);;
        		}
        		
        	}
        }
   
        return answer;
    }
}
