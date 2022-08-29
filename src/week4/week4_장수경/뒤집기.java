import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Week4_뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 버퍼 인풋
		
		char[] input = br.readLine().toCharArray();// 입력 받기
		int zcount=0;//0 갯수
		int ocount=0;//1 갯수
		
		if(input[0]=='0') ocount++;// 첫 인덱스 값 갯수 세기
		else zcount++;
		
		for (int i = 1; i < input.length; i++) {//나머지 입력에 대하여
			if(input[i-1]!=input[i]) {//앞 뒤 서로 값이 다르면
				if(input[i]=='0') ocount++;//다음 값에 맞춰 0이면 0갯수++
				else zcount++;//1이면 1갯수 ++
			}
		}

	
		System.out.println(Math.min(zcount, ocount));// 더 작은 값으로 결과 출력
		
		
	}

}
