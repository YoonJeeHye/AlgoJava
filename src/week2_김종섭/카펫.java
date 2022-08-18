package august_2th;

public class 카펫 {
	
	public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
		
        for (int x = 1; x < 2500; x++) {
        	if(x + yellow/x == (brown-4)/2 && x >= yellow/x) {
				answer =  new int[] {x+2,yellow/x + 2};	
                break;
			}
		}
				
		return answer;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
