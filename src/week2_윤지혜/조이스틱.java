package week2_윤지혜;

public class 조이스틱 {
	
	// 1. 상하 이동 회수
	// 2. 좌우 이동 회수
	
	public static int solution(String name) {
		int answer = 0;
		int move_cnt = name.length()-1;
		

		for(int i = 0; i < name.length(); i++) {
			// 1. name[i]가 알파벳 개수/2보다 위냐 아래냐 (상하 이동)
			
			//answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
			if(name.charAt(i) < ('A'+'Z')/2) {	// 알파벳 중간값 이하이면('A'~'M')
				answer += name.charAt(i)-'A';
			}else {	// 중간값 이상이면 ('N'~'Z')
				answer += 'Z'+1-name.charAt(i);
			}
			
			
			// 2. 앞으로 쭉 가는거(move_cnt)랑 중간에 A 껴있을 경우 왔다갔다 하는 것 중에 뭐가 더 최소값 나오는지 (좌우 이동)
			int indexA = i+1;
			while(indexA < name.length() && name.charAt(indexA) == 'A') {	// A가 있는 마지막 곳 찾아내기
				indexA++;
			}
			// i+i+name.length()-indexA : i만큼 뒤로 갔다 앞으로 갔다, 뒤부터 다시 앞쪽으로 가며 A 있는 곳까지 이동수 더함
			// 여기 다시 생각해봐야 함 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅟㅏㅜㄴㅁ아ㅓㅜㅏ어문
			move_cnt = Math.min(move_cnt, i+Math.min(i, name.length()-indexA)+name.length()-indexA);
		}
		answer += move_cnt;
		
        return answer;
    }

	public static void main(String[] args) {
		
		String name = "JAN";
		System.out.println(solution(name));
		//solution(name);
	}

}
