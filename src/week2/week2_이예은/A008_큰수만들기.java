package week2.week2_이예은;

class A008_큰수만들기 {
    public String solution(String number, int k) {
       String answer = "";
        
        int N = number.length();
        int[] nums = new int[N];
        
        for(int i = 0; i < N; i++)
        	nums[i] = number.charAt(i) - '0';// String으로 저장된 number를 int 배열로 저장한다
        
        // 범위내에서 가장 최대값을 추가해서 가장 큰수를 만든다
        // N의 길이중에 N-k길이의 숫자열을 찾아야 하기때문에
        // 시작은 0부터 시작하고 끝은 N-(N-k)로 초기화 한다 
        int start = 0;
        int end = N-(N-k); 
        
        for(int i = 0; i < N-k; i++) {// 정답에 N-k길이의 숫자열을 저장한다
        	int max = 0;
        	
        	for(int j = start; j <= end; j++) {
                if(max >= nums[j]) continue; // 만약 저장된 max 보다 작다면 계속 탐색한다
                max = nums[j];// 저장된 max보다 클경우는 max와 다음 start 를 바꿔준다
                start = j;
                if(max == 9) break;// 최고값이 9라면 더이상 탐색을 그만한다 -> 시간복잡도를 줄이기 위해 사용
        	}
        	answer += max;// 정답배열에 넣어준다 앞자리 부터 찬다
        	end++;// 구해야할 숫자열의 길이가 하나 줄었기 때무에 end index에 1을 더한다
        	start++;// 가장 큰 수의 index 다음 부터 탐색해야하기 때문에 start index에 1을 더한다
        }
        return answer;
    }
}