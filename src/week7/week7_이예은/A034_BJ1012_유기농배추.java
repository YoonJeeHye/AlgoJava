package week8.week8_이예은;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class A034_BJ1012_유기농배추 {

	static int N, M;
	static int[][] map;

	public static void dfs(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= M || map[y][x] == 0)
			return;

		map[y][x] = 0;
		dfs(y + 1, x);
		dfs(y - 1, x);
		dfs(y, x + 1);
		dfs(y, x - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		map = new int[50][50];

		for (int t = 0; t < T; t++) {
			String[] inputs = br.readLine().split(" ");
			M = Integer.parseInt(inputs[0]);
			N = Integer.parseInt(inputs[1]);
			int K = Integer.parseInt(inputs[2]);
			int count = 0;

			for (int i = 0; i < K; i++) {
				inputs = br.readLine().split(" ");
				int x = Integer.parseInt(inputs[0]);
				int y = Integer.parseInt(inputs[1]);
				map[y][x] = 1;
			}

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (map[y][x] == 1) {
						dfs(y, x);
						count++;
					}
				}
			}
			
			sb.append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}