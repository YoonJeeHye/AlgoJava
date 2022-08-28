package week4.week4_이예은;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class A016_BJ1713_후보추천하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		
		int[] recommended = new int[101]; // 추천수 저장
		int[] time = new int[101]; // 시간 저장
		
		List<Integer> photo = new LinkedList<>(); // 사진으로 걸리는 학생들 저장
		
		String[] inputs = br.readLine().split(" ");
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(inputs[t]);
			
			recommended[n]++;
			time[n] = t;
			if(photo.contains(n)) continue;
			
			
			if(photo.size() < N) {// 사진에 넣을 수 있다면 사진에 넣는다
				photo.add(n);
			} else { // 그렇지 않으면 사진에 걸린 학생중 한명을 빼고 넣는다
				int index = 0;
				int min_recommend = Integer.MAX_VALUE;
				int min_time = Integer.MAX_VALUE;
				
				for(int i = 0; i < N; i++) { // 모든 사진을 돌면서 추천수가 작고 추천을 받은지 가장 오래된 학생을 선택한다
					int num = photo.get(i);
					
					if(min_recommend > recommended[num] || (min_recommend == recommended[num] && min_time > time[n])) {
						index = i;
						min_recommend = recommended[num];
						min_time = time[num];
					} 
				}
				
				recommended[photo.get(index)] = 0; // 선택한 학생의 추천수를 0으로 초기화
				photo.remove(index); // 선택한 학생을 뺀다
				photo.add(n); // 새로운 학생을 넣는다				
			}
		}
		
		Collections.sort(photo);// 출력하기 전 정렬
		
		for(int i = 0; i < photo.size(); i++) {
			sb.append(photo.get(i)).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
