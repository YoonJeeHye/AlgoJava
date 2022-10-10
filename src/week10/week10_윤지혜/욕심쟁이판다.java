package week10.week10_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import java.io.*;
import java.util.*;

public class 욕심쟁이판다 {
	static int N;
	static int[][] arr;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int MAX;
	static int[][] Memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		MAX = Integer.MIN_VALUE;
		Memo = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				MAX = Math.max(MAX, DFS(i, j));
			}
		}
		
		System.out.println(MAX);
		
	}
	
	private static int DFS(int i, int j) {
		if(Memo[i][j] != 0) {	// 이미 계산한 곳이면
			return Memo[i][j];	// 그 값 주기
		}
		
		Memo[i][j] = 1;
		for(int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			
			if(arr[nr][nc] > arr[i][j]) {	// 대나무가 더 많을 경우에만
				Memo[i][j] = Math.max(Memo[i][j], DFS(nr,nc)+1);
				DFS(nr, nc);
			}
		}
		return Memo[i][j];
		
	}
	
}
