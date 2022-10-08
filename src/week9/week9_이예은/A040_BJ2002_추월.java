package week9.week9_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class A040_BJ2002_추월 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Boolean> checked = new HashMap<>(); // 해당 번호판을 체크했는지 확인한다
		String[] list = new String[N]; // 터널에 들어오는 순서대로 번호판을 저장한다
		
		for(int i = 0; i < N; i++) {
			String car = br.readLine();
			list[i] = car;
			checked.put(car, false);
		}
		
		int result = 0;
		int index = 0;
		for(int i = 0; i < N; i++) {
			String car = br.readLine();
			while(checked.get(list[index])) {
				index++;
			}
			if(!list[index].equals(car)) {
				checked.put(car, true);
				result++;
			} else {
				checked.put(car, true);
				index++;
			}
		}
		
		bw.write(result + "");
		br.close();
		bw.close();
	}
}
