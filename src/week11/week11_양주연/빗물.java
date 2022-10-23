package week11.week11_양주연;

import java.io.*;
import java.util.*;
public class 빗물
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int H = Integer.parseInt(input[0]); //행
		int W = Integer.parseInt(input[1]); //열
		int[] blockHeights = new int[W];
		int[] leftMax = new int[W]; //leftMax[i] -> 0번째 열부터 i번째 열까지(왼->오)의 블록 높이 중 최댓값.
		int[] rightMax = new int[W]; //rightMax[i] -> W-1번째 열부터 i번째 열까지(오->왼)의 블록 높이 중 최댓값.
		input = br.readLine().split(" ");
		int max=0;
		for(int i=0; i<W; i++){
		    blockHeights[i] = Integer.parseInt(input[i]);
		    if(blockHeights[i] > max) max = blockHeights[i];
		    leftMax[i] = max;
		}
		max=0;
		for(int i=W-1; i>=0; i--){
		    if(blockHeights[i] > max) max = blockHeights[i];
		    rightMax[i] = max;
		}
		// 현재 열의 왼쪽에 있는 열 중 가장 높은 블록의 높이, 오른쪽에 있는 열 중 가장 높은 블록의 높이를 구하고,
		// 구한 두 높이 중에 더 낮은 높이에서 현재 열의 블록 높이를 빼면 고이는 빗물의 양.
		// 뺀 결과가 음수일 경우엔 고이는 빗물의 양은 0.
		int answer=0;
		for(int i=1; i<W-1; i++){
		    answer += Math.max(0, Math.min(leftMax[i-1], rightMax[i+1]) - blockHeights[i]);
		}
		bw.write(answer+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}