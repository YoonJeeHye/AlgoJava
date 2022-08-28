package week2.week2_양주연;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = null;
        for(int height=1; height*height<=yellow; height++){
            if(yellow%height==0){
                int width = yellow/height;
                if(brown-4 == 2*(width+height)){
                    answer = new int[]{width+2, height+2};
                    break;
                }
            }
        }
        return answer;
    }
}