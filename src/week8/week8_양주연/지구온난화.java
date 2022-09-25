package week8.week8_양주연;

import java.io.*;
import java.util.*;
public class 지구온난화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int minR = 10, minC = 10, maxR = 0, maxC = 0;
        char[][] res = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) { 
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if ((x == -1 || y == -1 || x == R || y == C) || map[x][y] == '.') {
                            cnt++;
                        }
                    }
                    if (cnt < 3) {
                        res[i][j] = 'X';
                        minR = Math.min(minR, i);
                        minC = Math.min(minC, j);
                        maxR = Math.max(maxR, i);
                        maxC = Math.max(maxC, j);
                    } else {
                        res[i][j] = '.';
                    }
                } else {
                    res[i][j] = '.';
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                answer.append(res[i][j]);
            }
            answer.append("\n");
        }
        bw.write(answer.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}