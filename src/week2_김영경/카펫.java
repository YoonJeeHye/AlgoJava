class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=(brown-2)/2;i>=3;i--){ // i는 헹
            int j=(brown+yellow)/i; //j는 열
            if((j-2)*(i-2)==yellow){
                answer[0]=i;
                answer[1]=j;
                break;
            }
        }
        
        return answer;
    }
}