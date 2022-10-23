package week9.week9_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class A045_BJ2002_추월 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Boolean> checked = new HashMap<>(); // 해당 번호판을 체크했는지 확인는 해쉬맵
		String[] list = new String[N]; //터널에 들어오는 순서대로 번호판을 저장하는 배열
		
		for(int i = 0; i < N; i++) {
			String car = br.readLine();
			list[i] = car; // 터널에 들어오는 순서대로 번호판을 저장한다
			checked.put(car, false); 
		}
		
		int result = 0;
		int index = 0;
		for(int i = 0; i < N; i++) {
			String car = br.readLine();
			while(checked.get(list[index])) { // 체크를 했던 차라면 다음 순서로 넘어간다
				index++; // 다음 체크해줘야할 차를 가리키기 위해 index++한다
			}
			
			if(!list[index].equals(car)) { // 다음 순서에 와야할 차와 같지 않다면 -> 추월한것이다
				checked.put(car, true);
				result++;
			} else { // 다음 순서에 와야할 차와 같다면 -> 올바른 순서 , 추월하지 않은 것이다
				checked.put(car, true);
				index++; // 다음 체크해줘야할 차를 가리키기 위해 index++한다
			}
		}
		
		bw.write(result + "");
		br.close();
		bw.close();
	}
}
