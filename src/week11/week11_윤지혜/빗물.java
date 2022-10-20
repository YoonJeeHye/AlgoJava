package week11.week11_윤지혜;

import java.io.*;
import java.util.*;

public class 빗물 {

	static int H, W;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		H = Integer.parseInt(line[0]);
		W = Integer.parseInt(line[1]);
		
		arr = new int[W];
		line = br.readLine().split(" ");
		for(int w = 0; w < W; w++) {
			arr[w] = Integer.parseInt(line[w]);
		}
		
		int answer = 0;
		
		// 가운데에 있는 애들 기준으로
		for(int i = 1; i < W-1; i++) {
			int start = 0;
			int end = 0;
			for(int s = 0; s < i; s++) {	// 시작 지점 잡기
				start = Math.max(arr[s], start);
			}
			for(int e = i+1; e < W; e++) {	// 끝 지점 잡기
				end = Math.max(arr[e], end);
			}
			if(arr[i] < start && arr[i] < end) {	// 시작, 끝 중 더 작은 값에서 자기 뺀거 더해주기
				answer += Math.min(start, end) - arr[i];
			}
		}
		
		System.out.println(answer);
	}

}
