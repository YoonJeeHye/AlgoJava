package week8.week8_양주연;

import java.io.*;
import java.util.*;
public class 킹
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, int[]> mvMap = new HashMap<>();
		mvMap.put("R", new int[]{1, 0});
		mvMap.put("L", new int[]{-1, 0});
		mvMap.put("B", new int[]{0, 1});
		mvMap.put("T", new int[]{0, -1});
		mvMap.put("RT", new int[]{1, -1});
		mvMap.put("LT", new int[]{-1, -1});
		mvMap.put("RB", new int[]{1, 1});
		mvMap.put("LB", new int[]{-1, 1});
		String[] input = br.readLine().split(" ");
		int kingX = input[0].charAt(0)-65;
		int kingY = 8-(input[0].charAt(1)-48);
		int stoneX = input[1].charAt(0)-65;
		int stoneY = 8-(input[1].charAt(1)-48);
		int N = Integer.parseInt(input[2]);
		for(int i=0; i<N; i++){
		    String cmd = br.readLine();
		    int mx = mvMap.get(cmd)[0];
		    int my = mvMap.get(cmd)[1];
		    if(kingX+mx>=0 && kingX+mx<8 && kingY+my>=0 && kingY+my<8){
		        if(kingX+mx!=stoneX || kingY+my!=stoneY){
		            kingX+=mx;
		            kingY+=my;
		        }
		        else if(kingX+mx==stoneX && kingY+my==stoneY && stoneX+mx>=0 && stoneX+mx<8 && stoneY+my>=0 && stoneY+my<8){
		            kingX+=mx;
		            kingY+=my;
		            stoneX+=mx;
		            stoneY+=my;
		        }
		    }
		}
		bw.write("" + (char)(kingX+65) + (kingY*(-1)+8) + "\n");
		bw.write("" + (char)(stoneX+65) + (stoneY*(-1)+8) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
}