package dd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	static int r,c;
	
	static class Node{
		int x,y;
		
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
		
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int[] rcn=Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		r=rcn[0];
		c=rcn[1];
		int n=rcn[2];
		String[][] map=new String[r][c];
		
		Queue<Node> queueone=new ArrayDeque<>();
		
		for(int i=0;i<r;i++) {
			map[i]=bufferedReader.readLine().split("");
			for(int j=0;j<c;j++) {
				if(map[i][j].equals("O")) {
					queueone.add(new Node(i, j));
				}
			}
		}
		
		int cnt=1;
		if(cnt==n) {
			printmap(map);
			return;
		}
		
		while(true) {
			for(int i=0;i<r;i++) {
				Arrays.fill(map[i], "O");
			}
			cnt++;
			if(cnt==n) {
				printmap(map);
				return;
			}
			while(!queueone.isEmpty()) {
				Node node=queueone.poll();
				map[node.x][node.y]=".";
				if(node.x-1>=0) map[node.x-1][node.y]=".";
				if(node.x+1<r) map[node.x+1][node.y]=".";
				if(node.y-1>=0) map[node.x][node.y-1]=".";
				if(node.y+1<c) map[node.x][node.y+1]=".";
			}
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(map[i][j].equals("O")) {
						queueone.add(new Node(i, j));
					}
				}
			}
			cnt++;
			if(cnt==n) {
				printmap(map);
				return;
			}
		}
		
	}

	private static void printmap(String[][] map) {
		// TODO Auto-generated method stub
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}



}
